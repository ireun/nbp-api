package com.gatkowski.nbpapispring.currency;

import io.netty.handler.codec.http.HttpHeaderValues;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.net.URI;


@Component
public class CurrencyClient {
    private final WebClient.Builder builder;
    @Value("${nbp.currencyUrl:https://api.nbp.pl/api/exchangerates/rates/a/}")
    private String nbpUrl;

    public CurrencyClient(WebClient.Builder builder) {
        this.builder = builder;
    }

    private WebClient initializeClient() {
        return builder
                .defaultHeader(HttpHeaders.ACCEPT, String.valueOf(HttpHeaderValues.APPLICATION_JSON))
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
                .build();
    }

    /**
     * Queries NBP Api for exchange rates
     *
     * @param currencySymbol currency symbol to query, ISO 4217 format
     * @param nLastDays      number of days to be queried
     * @return {@code Mono} containing NBPRates for {@code currencySymbol}/PLN pair
     */
    public Mono<NBPRates> queryNbpForExchangeRates(String currencySymbol, int nLastDays) {
        return initializeClient()
                .get()
                .uri(URI.create(nbpUrl + currencySymbol + "/last/" + nLastDays))
                .retrieve()
                .bodyToMono(NBPRates.class);
    }
}
