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

    public Mono<Rates> getRates(String code, String nLastDays) {
        return currencyClient.queryNbpForExchangeRates(code, nLastDays)
                .flatMap(nbpRates -> {
                    final Rates rates = new Rates();
                    rates.setPair(nbpRates.getCode());
                    rates.setRates(nbpRates.getRates().stream()
                            .map(p -> new Rate(p.getEffectiveDate(), p.getMid()))
                            .collect(Collectors.toList()));
                    return Mono.just(rates);
                });
    }
}
