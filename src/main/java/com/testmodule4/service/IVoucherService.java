package com.testmodule4.service;

import com.testmodule4.model.Voucher;

import java.time.LocalDate;

public interface IVoucherService extends IService<Voucher> {
    Iterable<Voucher> findAllByDiscount(long discount);
    Iterable<Voucher> findAllByStartTime(LocalDate date);
    Iterable<Voucher> findAllByEndTime(LocalDate date);
}
