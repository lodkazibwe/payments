package com.kazam.payments.service.impl;

import com.kazam.payments.model.Payment;
import com.kazam.payments.repository.PaymentRepository;
import com.kazam.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getByCustomerName(String name) {
        return paymentRepository.findByCustomerName(name);
    }

    @Override
    public void deletePayment(int id) {
        paymentRepository.deleteById(id);
    }
}
