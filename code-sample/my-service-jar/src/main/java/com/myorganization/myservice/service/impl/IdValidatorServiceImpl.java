package com.myorganization.myservice.service.impl;

import com.myorganization.myservice.exception.IdValidationException;
import com.myorganization.myservice.model.response.ValidatorResponse;
import com.myorganization.myservice.service.IdValidatorService;
import com.myorganization.myservice.constants.Constants;
import com.myorganization.myservice.utils.Errors;
import com.myorganization.myservice.utils.IDUtils;
import com.jayway.jsonpath.JsonPath;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class IdValidatorServiceImpl implements IdValidatorService {

    @Override
    public ValidatorResponse checkValidId(String idValidatorRequest) {
        ValidatorResponse validatorResponse = new ValidatorResponse();
        List<Errors> errors = new ArrayList<>();
        validatorResponse.setErrors(errors);
        List<Map<String, String>> consumers = JsonPath.read(idValidatorRequest, "$.*.*.personalInformation");

        for (int j = 0; j < consumers.size(); j++) {

            String idCode = consumers.get(j).get("idCode");
            String idType = consumers.get(j).get("idType");
            String idCountryCode = consumers.get(j).get("idCountryCode");

            checkId(validatorResponse, idCode, idType, idCountryCode);

            if (!validatorResponse.getErrors().isEmpty()) {

                validatorResponse.setIdDocumentType(null);
                return validatorResponse;
            }
        }

        validatorResponse.setErrors(null);
        return validatorResponse;

    }

    private void checkId(ValidatorResponse validatorResponse, String idCode, String idType, String idCountryCode) {
        String document = "NIF";

        if (idType == null) {
            idType = Constants.IDTYPE_ID;
        }
        if (idCountryCode == null || Constants.IDCOUNTRYCODE_SPAIN.equals(idCountryCode)) {
            try {
                document = IDUtils.determineAndValidateSpainIdType(idCode, idType);
                setDocument(validatorResponse, document);
            } catch (IdValidationException e) {
                validatorResponse.getErrors()
                        .add(new Errors(Errors.CODE_IDVALIDATION_ERROR, "Invalid id"));

            }
        }else {
            setDocument(validatorResponse, document);
        }

    }

    private void setDocument(ValidatorResponse validatorResponse, String document ) {
        if(validatorResponse.getIdDocumentType() == null) {
            validatorResponse.setIdDocumentType( document);
        }
    }

}
