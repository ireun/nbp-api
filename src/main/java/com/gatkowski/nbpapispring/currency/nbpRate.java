package com.gatkowski.nbpapispring.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class nbpRate {
    private String effectiveDate;
    private BigDecimal mid;

    public nbpRate(String date, BigDecimal value) {
        this.effectiveDate = date;
        this.mid = value;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }
}
