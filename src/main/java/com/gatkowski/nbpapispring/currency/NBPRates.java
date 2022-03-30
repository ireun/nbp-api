package com.gatkowski.nbpapispring.currency;

import java.util.List;

public class NBPRates {
    String code;
    private List<NBPRate> rates;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<NBPRate> getRates() {
        return rates;
    }

    public void setRates(List<NBPRate> rates) {
        this.rates = rates;
    }
}
