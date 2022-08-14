package com.app.creditcard.service;

import com.app.creditcard.exception.CardNumberNotValidException;
import com.app.creditcard.exception.CvcNotValidException;
import com.app.creditcard.exception.DateExpiredException;
import com.app.creditcard.model.CreditCard;
import com.app.creditcard.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CreditCardService {

    public Response validateCreditCard(CreditCard creditCard) throws ParseException {

        if (!isCreditCardNumberValid(creditCard.getCardNumber()))
            throw new CardNumberNotValidException("Not valid card number");

        if (!isValidCvc(creditCard.getCvc(), isAmericanExpressCardNumber(creditCard.getCardNumber())))
            throw new CvcNotValidException("Not valid cvc");

        if (!validateExpireDate(creditCard.getExpireDate()))
            throw new DateExpiredException("Date expired");

        return new Response("Card is valid", HttpStatus.OK.value());
    }

    private boolean isCreditCardNumberValid(String cardNumber){
        int nSum = 0;
        boolean isSecond = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int d = cardNumber.charAt(i) - '0';

            if (isSecond)
                d = d * 2;

            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }

    private boolean isAmericanExpressCardNumber(String cardNumber) {
        return cardNumber.startsWith("34") || cardNumber.startsWith("37");
    }

    private boolean isValidCvc(int cvc, boolean isAmericanExpressCardNumber){
        final int response = cvc/100;
        if (response >= 1 && response <= 9 && !isAmericanExpressCardNumber)
            return true;

        return response >= 10 && response <= 99 && isAmericanExpressCardNumber;
    }

    private boolean validateExpireDate(String expireDate) throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
        dateFormat.setLenient(false);
        final Date expire = dateFormat.parse(expireDate);

        return expire.after(new Date(System.currentTimeMillis()));
    }

}
