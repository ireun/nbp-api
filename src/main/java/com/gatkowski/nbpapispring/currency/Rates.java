package com.gatkowski.nbpapispring.currency;

import reactor.core.publisher.Mono;

import java.util.List;

public class Rates {
    String code;
    private List<Rate> rates;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
