package com.gatkowski.nbpapispring;

import com.gatkowski.nbpapispring.gold.Gold;
import com.gatkowski.nbpapispring.gold.GoldClient;
import com.gatkowski.nbpapispring.gold.GoldService;
import com.gatkowski.nbpapispring.gold.NBPGold;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootTest
class GoldServiceTest {

    @Autowired
    GoldService goldService;

    @Autowired
    GoldClient goldClient;

    @Test
    void shouldReturnCorrectValue() {
        Flux<NBPGold> nbpGoldFlux = Flux.just(new NBPGold(LocalDate.now(), BigDecimal.TEN),
                new NBPGold(LocalDate.now(), BigDecimal.ZERO));
        Mono<Gold> goldMono = goldService.calculateAvgGoldPrice(nbpGoldFlux, 2);

        StepVerifier
                .create(goldMono)
                .expectNextMatches(p -> p.getPrice().stripTrailingZeros()
                        .equals(new BigDecimal(5)))
                .verifyComplete();

    }

    @Test
    void shouldReturnSingleValue() {
        Flux<NBPGold> nbpGoldFlux = goldClient.queryNbpForGoldPrice(14);
        Mono<Gold> averageGoldPrice = goldService.getAverageGoldPrice(nbpGoldFlux, 14);

        StepVerifier
                .create(averageGoldPrice)
                .expectNextCount(1)
                .verifyComplete();
    }

}
