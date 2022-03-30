package com.gatkowski.nbpapispring.currency;

import io.netty.handler.codec.http.HttpHeaderValues;
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

    public CurrencyClient(WebClient.Builder builder) {
        this.builder = builder;
    }

    public Mono<NBPRates> queryNbpForExchangeRates(String currencySymbol, String nLastDays) {
        return builder
                .defaultHeader(HttpHeaders.ACCEPT, String.valueOf(HttpHeaderValues.APPLICATION_JSON))
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
                .build()
                .get()
                .uri(URI.create("https://api.nbp.pl/api/exchangerates/rates/a/" + currencySymbol + "/last/" + nLastDays))
                .retrieve()
                .bodyToMono(NBPRates.class);
    }
}
