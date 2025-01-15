package com.testmodule4.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StartTimeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidStartTime {
    String message() default "Invalid voucher start time: Start Date must be after today";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
