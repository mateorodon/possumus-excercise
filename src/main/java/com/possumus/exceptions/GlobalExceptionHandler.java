package com.possumus.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidRomanNumberException.class)
    public ResponseEntity<String> handleInvalidRoman(InvalidRomanNumberException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }

    @ExceptionHandler(InvalidArabicNumberException.class)
    public ResponseEntity<String> handleInvalidArabic(InvalidArabicNumberException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }
}
