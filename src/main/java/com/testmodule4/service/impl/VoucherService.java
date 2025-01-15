package com.testmodule4.service.impl;

import com.testmodule4.model.Voucher;
import com.testmodule4.repository.IVoucherRepository;
import com.testmodule4.service.IVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Service
public class VoucherService implements IVoucherService {
    @Autowired
    private IVoucherRepository voucherRepository;

    @Override
    public Iterable<Voucher> findAll() {
        return voucherRepository.findAll();
    }

    @Override
    public Voucher save(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    @Override
    public Optional<Voucher> findById(Long id) {
        return voucherRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        voucherRepository.deleteById(id);
    }

    @Override
    public Collection<? extends Voucher> findAllByDiscount(long discount) {
        return voucherRepository.findAllByDiscount(discount);
    }

    @Override
    public Collection<? extends Voucher> findAllByStartTime(LocalDate date) {
        return voucherRepository.findAllByStartTime(date);
    }

    @Override
    public Collection<? extends Voucher> findAllByEndTime(LocalDate date) {
        return voucherRepository.findAllByEndTime(date);
    }
}
