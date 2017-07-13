package com.floppylab.booksvuedemo.util;

public class RecordAlreadyExistsException {

    private String errorMessage;

    public RecordAlreadyExistsException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}

