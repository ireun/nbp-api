package com.gatkowski.nbpapispring.currency;

public class InvalidCurrencyException extends Exception {

    public InvalidCurrencyException() {
        super("Invalid Currency Code provided");
    }
}
