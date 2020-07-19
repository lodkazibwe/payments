package com.kazam.payments.repository;


import com.kazam.payments.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByCustomerName(String customerName);
}
