package com.testmodule4.repository;

import com.testmodule4.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;

@Repository
public interface IVoucherRepository extends JpaRepository<Voucher, Long> {

    Collection<Voucher> findAllByDiscount(long discount);

    Collection<Voucher> findAllByStartTime(LocalDate date);

    Collection<Voucher> findAllByEndTime(LocalDate date);

    @Query(value = "from Voucher where discount=:discount and startTime=:startDate and endTime=:endDate")
    Iterable<Voucher> findAllByThreeFields(long discount, LocalDate startDate, LocalDate endDate);
}
