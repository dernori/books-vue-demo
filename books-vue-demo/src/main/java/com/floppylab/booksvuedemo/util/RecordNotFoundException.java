package com.floppylab.booksvuedemo.util;

public class RecordNotFoundException {

    private String errorMessage;

    public RecordNotFoundException(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}

