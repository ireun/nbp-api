package com.gatkowski.nbpapispring.gold;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class GoldService {
    private final GoldClient goldClient;

    public GoldService(GoldClient goldClient) {
        this.goldClient = goldClient;
    }

    public Mono<Gold> getRates(String nLastDays) {
        return goldClient.queryNbpForGoldPrice(nLastDays)
                .map(nbpGold::getCena)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .map(Gold::new);
//                .flatMap(nbpRates -> {
//                    final Rates rates = new Rates();
//                    rates.setPair(nbpRates.getCode());
//                    rates.setRates(nbpRates.getRates().stream()
//                            .map(p -> new Rate(p.getEffectiveDate(), p.getMid()))
//                            .collect(Collectors.toList()));
//                    return Mono.just(rates);
//                });
    }
}
