package com.app.creditcard.model;

import com.app.creditcard.validation.CardNumber;
import com.app.creditcard.validation.Dateformat;

import javax.validation.constraints.NotEmpty;

public class CreditCard {

    @CardNumber
    private String cardNumber;

    private int cvc;

    @NotEmpty(message = "Full name must not be empty")
    private String fullName;

    @NotEmpty(message = "Month must not be empty")
    private String expireDateMonth;

    @NotEmpty(message = "Year must not be empty")
    private String expireDateYear;

    public String getExpireDateMonth() {
        return expireDateMonth;
    }

    public void setExpireDateMonth(String expireDateMonth) {
        this.expireDateMonth = expireDateMonth;
    }

    public String getExpireDateYear() {
        return expireDateYear;
    }

    public void setExpireDateYear(String expireDateYear) {
        this.expireDateYear = expireDateYear;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName.trim();
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber.trim();
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    @Dateformat
    public String getExpireDate() {
        return expireDateMonth + "/" + expireDateYear;
    }
}
