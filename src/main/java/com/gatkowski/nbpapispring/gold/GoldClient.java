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

    public Flux<nbpGold> queryNbpForGoldPrice(String nLastDays) {
        return builder
                .defaultHeader(HttpHeaders.ACCEPT, String.valueOf(HttpHeaderValues.APPLICATION_JSON))
                .clientConnector(new ReactorClientHttpConnector(HttpClient.newConnection().compress(true)))
                .build()
                .get()
                .uri(URI.create("https://api.nbp.pl/api/cenyzlota/last/" + nLastDays))
                .retrieve()
                .bodyToFlux(nbpGold.class);
    }
}
