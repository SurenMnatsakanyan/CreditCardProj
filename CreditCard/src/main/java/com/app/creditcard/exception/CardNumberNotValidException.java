package com.app.creditcard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CardNumberNotValidException extends RuntimeException{

    public CardNumberNotValidException(String message) {
        super(message);
    }
}
