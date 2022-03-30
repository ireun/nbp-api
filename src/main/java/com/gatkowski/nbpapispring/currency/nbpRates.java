package com.gatkowski.nbpapispring.currency;

import java.util.List;

public class nbpRates {
    String code;
    private List<nbpRate> rates;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<nbpRate> getRates() {
        return rates;
    }

    public void setRates(List<nbpRate> rates) {
        this.rates = rates;
    }
}
