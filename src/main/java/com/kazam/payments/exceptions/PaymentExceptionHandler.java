package com.kazam.payments.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class PaymentExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetail errorDetail=new ErrorDetail(new Date(),
                "Method Argument Not Valid",ex.getMessage(), status);
        return new ResponseEntity<>(errorDetail, status);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(
            MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetail errorDetail=new ErrorDetail(new Date(),
                "Missing PathVariable",ex.getMessage(),status);
        return new ResponseEntity<>(errorDetail, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetail errorDetail=new ErrorDetail(new Date(),
                "Method Not Supported",ex.getMessage(), status);
        return new ResponseEntity<>(errorDetail,status);

    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(
            HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ErrorDetail errorDetail=new ErrorDetail(new Date(),
                "Message Not Readable",ex.getMessage(), status);
        return new ResponseEntity<>(errorDetail,status);
    }
}
