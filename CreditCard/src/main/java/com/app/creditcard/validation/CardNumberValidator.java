package com.app.creditcard.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberValidator implements ConstraintValidator<CardNumber, String> {

    @Override
    public void initialize(CardNumber constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String text, ConstraintValidatorContext constraintValidatorContext) {
        return text != null && text.length() >= 16 && text.length() <= 19 && isAllNumbers(text);
    }

    private boolean isAllNumbers(String text) {
        char[] chars = text.toCharArray();
        for (char c : chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }
}
