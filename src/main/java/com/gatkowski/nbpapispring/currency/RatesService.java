package com.gatkowski.nbpapispring.currency;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@Service
public class RatesService {
    private final CurrencyClient currencyClient;

    public RatesService(CurrencyClient currencyClient) {
        this.currencyClient = currencyClient;
    }

    public Mono<Rates> getRates(String code, String nLastDays) throws ExecutionException, InterruptedException {
        return currencyClient.queryNbpForExchangeRates(code, nLastDays)
                .flatMap(nbpRates -> {
                    final Rates rates = new Rates();
                    rates.setCode(nbpRates.getCode());
                    rates.setRates(nbpRates.getRates().stream()
                            .map(p -> new Rate(p.getEffectiveDate(), p.getMid()))
                            .collect(Collectors.toList()));
                    return Mono.just(rates);
                });
    }
}
