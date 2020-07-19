package com.kazam.payments.service;

import com.kazam.payments.model.Payment;

import java.util.List;

public interface PaymentService {
    Payment savePayment(Payment payment);
    Payment getPayment(int id);
    List<Payment> getAllPayments();
    List<Payment> getByCustomerName(String name);
    void deletePayment(int id);

}
