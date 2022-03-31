package com.gatkowski.nbpapispring.gold;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class GoldService {


    /**
     * Calculates average Gold Price
     * @param nbpGoldFlux {@code Flux} containing prices to be averaged
     * @param nLastDays number of days contained in {@code nbpGoldFlux}
     */
    public Mono<Gold> getAverageGoldPrice(Flux<NBPGold> nbpGoldFlux, int nLastDays) {
        BigDecimal divisor = new BigDecimal(nLastDays);
        return nbpGoldFlux.map(NBPGold::getCena)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .map(p -> p.divide(divisor, 5, RoundingMode.HALF_EVEN))
                .map(Gold::new);
    }
}