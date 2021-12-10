package com.sample.coin.mincoinchangeapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MinCoinChangeExceptionInterceptor extends ResponseEntityExceptionHandler {
    @ExceptionHandler(InvalidBillException.class)
    public final ResponseEntity<Object> handleAllExceptions(CoinsInsufficientException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}
