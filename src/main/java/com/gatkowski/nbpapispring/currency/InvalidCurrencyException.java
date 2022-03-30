package com.gatkowski.nbpapispring.currency;

public class InvalidCurrencyException extends RuntimeException {

    public InvalidCurrencyException() {
        super("Invalid Currency Code provided");
    }
}
