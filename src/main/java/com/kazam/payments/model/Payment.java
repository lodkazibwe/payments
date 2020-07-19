package com.kazam.payments.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String customerName;
    @NotNull
    private double amount;
    private LocalDate paymentDate;


}
