package com.gatkowski.nbpapispring.currency;

import java.util.List;

/**
 * Representation of NBP API currency exchange response
 */
public class NBPRates {

    final String code;
    private final List<NBPRate> rates;

    public NBPRates(String code, List<NBPRate> rates) {
        this.code = code;
        this.rates = rates;
    }

    public String getCode() {
        return code;
    }

    public List<NBPRate> getRates() {
        return rates;
    }
}
