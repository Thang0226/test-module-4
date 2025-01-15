package com.testmodule4.repository;

import com.testmodule4.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IVoucherRepository extends JpaRepository<Voucher, Long> {

    Iterable<Voucher> findAllByDiscount(long discount);

    Iterable<Voucher> findAllByStartTime(LocalDate date);

    Iterable<Voucher> findAllByEndTime(LocalDate date);
}
