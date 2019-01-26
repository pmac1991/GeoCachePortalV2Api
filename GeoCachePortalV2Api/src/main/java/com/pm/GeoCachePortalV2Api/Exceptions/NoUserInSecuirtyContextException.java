package com.pm.GeoCachePortalV2Api.Exceptions;

public class NoUserInSecuirtyContextException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    private final String message;

    public NoUserInSecuirtyContextException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
