package com.myorganization.myservice.controller;

import com.myorganization.myservice.model.response.ValidatorResponse;
import com.myorganization.myservice.service.IdValidatorService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.myorganization.myservice.constants.SwaggerConstants.*;

@RestController
@RequestMapping("/api/idvalidator")
@Api(value = "myservice", tags = "Id validator for General ICSaaS Custom Service API")
@Validated
public class idValidatorController {

	Logger logger = LoggerFactory.getLogger(getClass().getName());

	@Autowired
	public idValidatorController() {
	}

	@Autowired
	IdValidatorService idValidatorService;

	@PostMapping(path = "", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Id Validator Endpoint", notes = "Reference Scope Endpoint", response = ValidatorResponse.class,
	extensions = {
			@Extension(name = X_EXTENDED_PROPERTIES_KEY, properties = {@ExtensionProperty(name = OPERATION_TYPE_KEY, value = BUSINESS_TYPE_KEY),}),
			@Extension(name = X_TRANSLATIONS_KEY,
					properties = {@ExtensionProperty(name = SUMMARY_KEY, value = SUMMARY_PACKAGE_IDVALIDATOR_KEY),
							@ExtensionProperty(name = DESCRIPTION_KEY, value = DESCRIPTION_PACKAGE_KEY),							
							@ExtensionProperty(name = PAYLOAD_CUSTOMSERVICE_PARAM_NAME_KEY, value = PAYLOAD_CUSTOMSERVICE_PARAM_PACKAGE_KEY),	
							@ExtensionProperty(name = INPUTTEXT_CODE_PARAM_NAME_KEY, value = INPUTTEXT_CODE_PARAM_PACKAGE_KEY),
							@ExtensionProperty(name = PATH_NAME_KEY, value = PATH_ID_VALIDATOR_DESCRIPTION_KEY)})})
	public ResponseEntity<ValidatorResponse> checkValidId(@ApiParam(name = "myServiceRequest", value = "Body") @RequestBody(required = false) final String request) {
					
		ValidatorResponse response = idValidatorService.checkValidId(request);
		
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(response);
	}
	
}
