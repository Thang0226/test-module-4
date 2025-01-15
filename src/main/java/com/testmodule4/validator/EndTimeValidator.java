package com.testmodule4.validator;

import com.testmodule4.model.Voucher;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class EndTimeValidator implements ConstraintValidator<ValidEndTime, Voucher> {
    @Override
    public boolean isValid(Voucher voucher, ConstraintValidatorContext context) {
        if (voucher == null) {
            return true;
        }

        return voucher.getEndTime().isAfter(voucher.getStartTime());
    }
}