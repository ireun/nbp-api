package com.gatkowski.nbpapispring.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Rate {
    private String date;
    private BigDecimal value;

    public Rate(String date, BigDecimal value) {
        this.date = date;
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getValue() {
        return BigDecimal.ONE.divide(value, value.scale(), RoundingMode.HALF_EVEN);
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
