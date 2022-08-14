package com.app.creditcard.controller;

import com.app.creditcard.model.CreditCard;
import com.app.creditcard.model.Response;
import com.app.creditcard.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping("/credit-card")
@CrossOrigin("http://localhost:3000")
public class CreditCardController {

    private final CreditCardService creditCardService;

    @Autowired
    public CreditCardController(CreditCardService creditCardService) {
        this.creditCardService = creditCardService;
    }

    @GetMapping("/validate")
    public ResponseEntity<Response> validateCreditCard(@Valid CreditCard creditCard) throws ParseException {
        return ResponseEntity.ok(creditCardService.validateCreditCard(creditCard));
    }
}