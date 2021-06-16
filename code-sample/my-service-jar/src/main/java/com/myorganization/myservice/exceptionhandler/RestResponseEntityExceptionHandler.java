package com.myorganization.myservice.exceptionhandler;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myorganization.myservice.model.response.MyServiceResponse;
import com.myorganization.myservice.model.response.ErrorRequest;
import com.myorganization.myservice.model.response.GeneralInfo;


@org.springframework.web.bind.annotation.ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
                                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {

        LOGGER.error(String.format("Error request param----------------- %s", ex.getMessage()));
        return handleExceptionInternal(ex, setCodeAndMessage(request), new HttpHeaders(), HttpStatus.OK, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {

        LOGGER.error(String.format("Error body----------------- %s" , ex.getBindingResult()));
        return handleExceptionInternal(ex, setCodeAndMessage(request), new HttpHeaders(), HttpStatus.OK, request);
    }

    private MyServiceResponse setCodeAndMessage(WebRequest request) {

        MyServiceResponse response = new MyServiceResponse();

        String returnCode="999";
        String code="GEN000";
        String message="GENERAL ERROR";

        response.setErrors(Arrays.asList(ErrorRequest.builder().code(code).message(message).build()));
        response.setMyServiceGeneralInfo(GeneralInfo.builder().returnCode(returnCode).build());
        return response;
    }

}
