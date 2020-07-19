package com.kazam.payments.converter;

import com.kazam.payments.dto.PaymentDto;
import com.kazam.payments.model.Payment;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PaymentConverter {
    public PaymentDto entityToDto (Payment payment){
        PaymentDto paymentDto=new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setCustomerName(payment.getCustomerName());
        return paymentDto;
    }

    public Payment DtoToEntity (PaymentDto paymentDto){
        Payment payment=new Payment();
        payment.setId(paymentDto.getId());
        payment.setAmount(paymentDto.getAmount());
        payment.setCustomerName(paymentDto.getCustomerName());
        payment.setPaymentDate(LocalDate.now());
        return payment;
    }

}
