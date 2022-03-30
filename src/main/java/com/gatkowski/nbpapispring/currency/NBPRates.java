package com.gatkowski.nbpapispring.currency;

import java.util.List;

public class NBPRates {
    String code;
    private List<NBPRate> rates;

    public String getCode() {
        return code;
    }

    public List<NBPRate> getRates() {
        return rates;
    }
}
