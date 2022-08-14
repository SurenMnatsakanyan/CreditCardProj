package com.app.creditcard.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CardNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CardNumber {

    String message() default "Invalid card number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
