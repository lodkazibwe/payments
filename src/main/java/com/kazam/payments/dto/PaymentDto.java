package com.kazam.payments.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
public class PaymentDto {
    @GeneratedValue
    private int id;
    @NotNull
    private String customerName;
    @NotNull
    private double amount;
}
