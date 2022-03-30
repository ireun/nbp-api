package com.gatkowski.nbpapispring.currency;

import java.util.List;

public class Rates {
    String pair;
    private List<Rate> rates;

    public String getPair() {
        return "PLN/" + pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
