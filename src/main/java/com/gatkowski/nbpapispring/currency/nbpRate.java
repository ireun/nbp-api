package com.gatkowski.nbpapispring.currency;

import java.math.BigDecimal;
import java.time.LocalDate;

public class nbpRate {
    private LocalDate effectiveDate;
    private BigDecimal mid;

    public nbpRate(LocalDate date, BigDecimal value) {
        this.effectiveDate = date;
        this.mid = value;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }
}
