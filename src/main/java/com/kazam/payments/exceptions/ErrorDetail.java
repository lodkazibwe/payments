package com.kazam.payments.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ErrorDetail {
    private Date timeStamp;
    private String message;
    private String errorDetails;
    private HttpStatus status;
}
