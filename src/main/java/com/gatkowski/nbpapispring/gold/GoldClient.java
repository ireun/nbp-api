package com.gatkowski.nbpapispring.gold;

import io.netty.handler.codec.http.HttpHeaderValues;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.netty.http.client.HttpClient;

import java.net.URI;


@Component
public class GoldClient {
    private final WebClient.Builder builder;

    public GoldClient(WebClient.Builder builder) {
        this.builder = builder;
    }

    private WebClient initializeClient() {
        return builder
                .defaultHeader(HttpHeaders.ACCEPT, String.valueOf(HttpHeaderValues.APPLICATION_JSON))
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
                .build();
    }

    /**
     * Queries NBP Api for gold prices
     *
     * @param nLastDays number of days to be queried
     * @return {@code Flux} containing {@code NBPGold}
     */
    public Flux<NBPGold> queryNbpForGoldPrice(int nLastDays) {
        return initializeClient()
                .get()
                .uri(URI.create("https://api.nbp.pl/api/cenyzlota/last/" + nLastDays))
                .retrieve()
                .bodyToFlux(NBPGold.class);
    }
}
