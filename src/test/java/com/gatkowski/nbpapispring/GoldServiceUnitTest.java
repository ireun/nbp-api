package com.gatkowski.nbpapispring;

import com.gatkowski.nbpapispring.gold.Gold;
import com.gatkowski.nbpapispring.gold.GoldClient;
import com.gatkowski.nbpapispring.gold.GoldService;
import com.gatkowski.nbpapispring.gold.NBPGold;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GoldServiceUnitTest {

    @Mock
    private GoldClient goldClient;

    @InjectMocks
    private GoldService goldService;

    @Test
    void shouldReturnCorrectAvg() {
        Flux<NBPGold> nbpGoldFlux = Flux.just(new NBPGold(LocalDate.now(), BigDecimal.valueOf(100)),
                new NBPGold(LocalDate.now(), BigDecimal.valueOf(0)),
                new NBPGold(LocalDate.now(), BigDecimal.valueOf(200)));

        when(goldClient.queryNbpForGoldPrice(3)).thenReturn(nbpGoldFlux);

        Mono<Gold> goldMono = goldService.getAverageGoldPrice(goldClient.queryNbpForGoldPrice(3), 3);

        StepVerifier
                .create(goldMono)
                .expectNextMatches(p -> p.getPrice().equals(new BigDecimal(100).setScale(5)))
                .expectComplete()
                .verify();
    }
}