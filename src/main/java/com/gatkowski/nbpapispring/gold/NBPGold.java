package com.gatkowski.nbpapispring.gold;

import java.math.BigDecimal;
import java.time.LocalDate;

public class NBPGold {
    private LocalDate data;
    private BigDecimal cena;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

}
