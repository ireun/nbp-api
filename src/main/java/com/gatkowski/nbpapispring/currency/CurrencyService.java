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
                    final Rates rates = new Rates(
                            nbpRates.getCode(),
                            nbpRates.getRates().stream()
                                    .map(NBPRate::toRate)
                                    .toList()
                    );
                    return Mono.just(rates);
                });
    }

    public Mono<Rates> getRates(String code, int nLastDays) {
        return convert(currencyClient.queryNbpForExchangeRates(code, nLastDays));
    }
}
