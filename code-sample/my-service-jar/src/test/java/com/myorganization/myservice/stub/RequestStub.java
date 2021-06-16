package com.myorganization.myservice.stub;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RequestStub {

    public String insertRequestIdValidatorStub(String IdType, String idCode, String idConuntryType) {

        return "{\"applicants\":{\"primaryConsumer\":{\"personalInformation\":{\"idType\":\"" + IdType + "\",\"idCode\":\"" + idCode + "\",\"idCountryCode\":"
                + "\""+ idConuntryType + "\"}},\"secondaryConsumer\":{\"personalInformation\":{\"idType\":\"ID\",\"idCode\":\"A00000000\"}}}}";

    }

    public String insertRequestIdValidatorStub(String idCode) {

        return "{\"applicants\":{\"primaryConsumer\":{\"personalInformation\":{\"idType\":" + null + ",\"idCode\":\"" + idCode + "\",\"idCountryCode\":"
                + ""+ null + "}},\"secondaryConsumer\":{\"personalInformation\":{\"idType\":\"ID\",\"idCode\":\"A00000000\"}}}}";

    }

    public String consentValidatorStub(String ok) {
        String response;
        if ("ok".equals(ok)) {
            response = "{\"applicants\":{\"primaryConsumer\":{\"personalInformation\":{\"idType\":\"ID\",\"idCode\":\"00001000B\",\"dataSources\":{\"EIPG\":{\"consentData\":{\"idNumber\":\"00001000B\",\"dniNumber\":\"\",\"fullName\":\"JhonSmith\",\"consentVersion\":\"1.0\",\"consentDate\":\"2020-10-0500:00:00\"}}}}}}}";
        }else {
            response = "{\"applican.ts\":{\"primaryConsumer\":{\"personalInformation\":{\"idType\":\"ID\",\"idCode\":\"00001000B\",\"dataSources\":{\"EIPG\":{\"consentData\":{\"idNumber\":\"00001000B\",\"dniNumber\":\"\",\"fullName\":\"JhonSmith\",\"consentVersion\":\"1.0\",\"consentDate\":\"2020-10-0500:00:00\"}}}}}}}";
        }
        return response;
    }

}
