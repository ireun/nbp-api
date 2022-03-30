package com.gatkowski.nbpapispring.gold;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class GoldService {
    private final GoldClient goldClient;

    public GoldService(GoldClient goldClient) {
        this.goldClient = goldClient;
    }

    public Mono<Gold> getRates(String nLastDays) {
        BigDecimal divisor = new BigDecimal(14);
        return goldClient.queryNbpForGoldPrice(nLastDays)
                .map(NBPGold::getCena)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .map(p -> p.divide(divisor, RoundingMode.HALF_EVEN))
                .map(Gold::new);
    }
}
