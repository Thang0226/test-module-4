package com.testmodule4.validator;

import com.testmodule4.model.Voucher;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class StartTimeValidator implements ConstraintValidator<ValidStartTime, Voucher> {
    @Override
    public boolean isValid(Voucher voucher, ConstraintValidatorContext context) {
        if (voucher == null) {
            return true;
        }
        LocalDate now = LocalDate.now();
        boolean isValid = !voucher.getStartTime().isBefore(now);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("startTime")
                    .addConstraintViolation();
        }
        return isValid;
    }
}