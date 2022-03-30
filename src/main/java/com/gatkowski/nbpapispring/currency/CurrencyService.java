package com.gatkowski.nbpapispring.currency;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class CurrencyService {
    private final CurrencyClient currencyClient;

    public CurrencyService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    private Mono<Rates> convert(Mono<NBPRates> nbpRatesMono) {
        return nbpRatesMono
                .flatMap(nbpRates -> {
                    final Rates rates = new Rates();
                    rates.setPair(nbpRates.getCode());
                    rates.setRateList(nbpRates.getRates().stream()
                            .map(p -> new Rate(p.getEffectiveDate(), p.getMid()))
                            .collect(Collectors.toList()));
                    return Mono.just(rates);
                });
    }

    public Mono<Rates> getRates(String code, String nLastDays) {
        return convert(currencyClient.queryNbpForExchangeRates(code, nLastDays));
    }
}
