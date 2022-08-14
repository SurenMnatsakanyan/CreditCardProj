package com.app.creditcard.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateFormatValidator implements ConstraintValidator<Dateformat, String> {

    private static final String EXPIRE_DATE_PATTERN = "^(0[1-9]|1[0-2])\\/?([0-9]{4}|[0-9]{2})$";

    @Override
    public void initialize(Dateformat constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String expireDate, ConstraintValidatorContext constraintValidatorContext) {
        if (expireDate == null)
            return false;

        final Pattern pattern = Pattern.compile(EXPIRE_DATE_PATTERN);
        final Matcher matcher = pattern.matcher(expireDate);
        return matcher.matches();
    }
}
