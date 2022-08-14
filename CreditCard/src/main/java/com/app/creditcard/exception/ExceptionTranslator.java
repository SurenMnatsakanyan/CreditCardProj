package com.app.creditcard.exception;

import com.app.creditcard.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(CardNumberNotValidException.class)
    public ResponseEntity<Response> handleCardNumberNotValidException(CardNumberNotValidException e){
        final Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }

    @ExceptionHandler(CvcNotValidException.class)
    public ResponseEntity<Response> handleCvvNotValidException(CvcNotValidException e){
        final Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }

    @ExceptionHandler(ParseException.class)
    public ResponseEntity<Response> handleParseException(ParseException e){
        final Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }

    @ExceptionHandler(DateExpiredException.class)
    public ResponseEntity<Response> handleDateExpiredException(DateExpiredException e){
        final Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        final String message = e.getBindingResult().getFieldError().getDefaultMessage();
        final Response response = new Response(message, HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<Response> handleBindException(BindException e){
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        final String field = e.getBindingResult().getFieldError().getField();
        
        if (field.equals("cvc"))
            message = "Not valid cvc";

        final Response response = new Response(message, HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(response);
    }
}
