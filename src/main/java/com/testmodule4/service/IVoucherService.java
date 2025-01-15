package com.testmodule4.service;

import com.testmodule4.model.Voucher;

import java.time.LocalDate;
import java.util.Collection;

public interface IVoucherService extends IService<Voucher> {
    Collection<? extends Voucher> findAllByDiscount(long discount);
    Collection<? extends Voucher> findAllByStartTime(LocalDate date);
    Collection<? extends Voucher> findAllByEndTime(LocalDate date);

    Iterable<Voucher> findAllByThreeFields(long discount, LocalDate startDate, LocalDate endDate);
}
