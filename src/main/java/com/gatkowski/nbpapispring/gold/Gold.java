package com.gatkowski.nbpapispring.gold;

import java.math.BigDecimal;

public class Gold {
    BigDecimal price;

    public Gold(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
