package com.app.creditcard.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateFormatValidator.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dateformat {

    String message() default "Invalid expire date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
