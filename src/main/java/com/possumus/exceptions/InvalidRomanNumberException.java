package com.possumus.exceptions;

public class InvalidRomanNumberException extends RuntimeException{
    public InvalidRomanNumberException(String message) {
        super(message);
    }
}
