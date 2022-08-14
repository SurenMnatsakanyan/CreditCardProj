package com.app.creditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CvvNotValidException extends RuntimeException{

    public CvvNotValidException(String message) {
        super(message);
    }
}
