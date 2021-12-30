package com.phdareys.tax.exception;

public class TaxException extends Exception{

    String message;
    public TaxException(String message) {this.message = message;}

    @Override
    public String getMessage() {
        return message;
    }
}
