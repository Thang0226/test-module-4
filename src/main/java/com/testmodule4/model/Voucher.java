package com.testmodule4.model;

import com.testmodule4.validator.ValidEndTime;
import com.testmodule4.validator.ValidStartTime;
import jakarta.persistence.*;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "voucher")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidStartTime(message = "Invalid voucher start time: Start Date must be after today")
@ValidEndTime(message = "Invalid voucher end time: End Date must be after Start Date")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate startTime;

    @NotNull
    private LocalDate endTime;

    @NotNull
    @Min(value = 10001, message = "Discount amount must be greater than 10.000 VND")
    private long discount;

    @NotNull
    private String details;
}
