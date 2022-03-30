package com.gatkowski.nbpapispring.currency;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NBPRate {
    private final LocalDate effectiveDate;
    private final BigDecimal mid;

    public NBPRate(LocalDate date, BigDecimal value) {
        this.effectiveDate = date;
        this.mid = value;
    }

    public Rate toRate() {
        return new Rate(this.effectiveDate, this.mid);
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public BigDecimal getMid() {
        return mid;
    }
}
