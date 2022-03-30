package com.gatkowski.nbpapispring.currency;

import java.util.List;

public class Rates {
    String pair;
    private List<Rate> rateList;

    public String getPair() {
        return "PLN/" + pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }

    public List<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }
}
