package com.myorganization.myservice.service;

import com.myorganization.myservice.model.response.ValidatorResponse;

public interface IdValidatorService {

    public ValidatorResponse checkValidId(String idValidatorRequest);

}
