package com.pm.GeoCachePortalV2Api.Exceptions;

public class NoAccessException extends Exception {

    private static final long serialVersionUID = 1L;

    private final String message;

    public NoAccessException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
