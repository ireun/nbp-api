package com.gatkowski.nbpapispring.currency;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Rate {
    private final LocalDate date;
    private final BigDecimal value;

    public Rate(LocalDate date, BigDecimal value) {
        this.date = date;
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }

    public BigDecimal getValue() {
        return BigDecimal.ONE.divide(value, 5, RoundingMode.HALF_EVEN);
    }

}
