package com.kazam.payments.controller;

import com.kazam.payments.converter.PaymentConverter;
import com.kazam.payments.dto.PaymentDto;
import com.kazam.payments.model.Payment;
import com.kazam.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired private PaymentConverter paymentConverter;

    @PostMapping("/addPayment")
    public ResponseEntity<PaymentDto> addPayment (@Valid @RequestBody PaymentDto paymentDto){
        Payment payment=paymentConverter.DtoToEntity(paymentDto);

        return new ResponseEntity<>(
                paymentConverter.entityToDto(paymentService.savePayment(payment)),
                HttpStatus.OK);
    }

    @GetMapping("/getPayment/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable int id){
        return new ResponseEntity<>(paymentService.getPayment(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Payment>> getAll(){
        return new ResponseEntity<>(paymentService.getAllPayments(),HttpStatus.OK);
    }

    @GetMapping("/customerPayments/{name}")
    public ResponseEntity<List<Payment>> getByCustomerId(@PathVariable String name){
        return new ResponseEntity<>(paymentService.getByCustomerName(name), HttpStatus.OK);
    }

    @DeleteMapping("/deletePayment/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id){
        paymentService.deletePayment(id);
        return new ResponseEntity<>("Payment "+id+" deleted",HttpStatus.OK);
    }



}
