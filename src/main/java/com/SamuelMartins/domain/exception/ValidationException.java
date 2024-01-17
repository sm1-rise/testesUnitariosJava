package com.SamuelMartins.domain.exception;

public class ValidationException extends RuntimeException{

    private static final long serialVersionUID = -3515151564654L;
    public ValidationException(String message) {
        super(message);
    }
}
