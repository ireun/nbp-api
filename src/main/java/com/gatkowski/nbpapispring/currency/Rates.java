package com.gatkowski.nbpapispring.currency;

import java.util.List;

public class Rates {
    final String pair;
    private final List<Rate> rateList;

    public Rates(String pair, List<Rate> rateList) {
        this.pair = pair;
        this.rateList = rateList;
    }

    public String getPair() {
        return "PLN/" + pair;
    }

    public List<Rate> getRateList() {
        return rateList;
    }
}
