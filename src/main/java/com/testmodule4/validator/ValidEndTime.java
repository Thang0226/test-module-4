package com.testmodule4.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EndTimeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEndTime {
    String message() default "Invalid voucher end time: End Date must be after Start Date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
