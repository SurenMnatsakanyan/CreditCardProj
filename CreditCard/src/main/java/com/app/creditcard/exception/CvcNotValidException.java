package com.app.creditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CvcNotValidException extends RuntimeException{

    public CvcNotValidException(String message) {
        super(message);
    }
}
