package com.gatkowski.nbpapispring.gold;

import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * Representation of NBP Api Gold price
 */
public class NBPGold {
    private LocalDate data;
    private BigDecimal cena;

    public NBPGold(LocalDate data, BigDecimal cena) {
        this.data = data;
        this.cena = cena;
    }

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
