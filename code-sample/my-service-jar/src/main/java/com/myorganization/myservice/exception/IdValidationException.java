package com.myorganization.myservice.exception;

public class IdValidationException extends Exception{

    private static final long serialVersionUID = -3777505806889102426L;

    public IdValidationException(String message) {
        super(message);
    }
}
