package com.gatkowski.nbpapispring.gold;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class GoldService {
    private final GoldClient goldClient;

    public GoldService(GoldClient goldClient) {
        this.goldClient = goldClient;
    }

    private Mono<Gold> calculateAvgGoldPrice(Flux<NBPGold> nbpGoldFlux, String nLastDays) {
        BigDecimal divisor = new BigDecimal(nLastDays);
        return nbpGoldFlux.map(NBPGold::getCena)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .map(p -> p.divide(divisor, 5, RoundingMode.HALF_EVEN))
                .map(Gold::new);
    }

    public Mono<Gold> getAverageGoldPrice(String nLastDays) {
        Flux<NBPGold> nbpGoldFlux = goldClient.queryNbpForGoldPrice(nLastDays);
        return calculateAvgGoldPrice(nbpGoldFlux, nLastDays);
    }
}
