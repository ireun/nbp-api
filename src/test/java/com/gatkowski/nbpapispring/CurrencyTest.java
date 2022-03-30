package com.gatkowski.nbpapispring;

import com.gatkowski.nbpapispring.currency.CurrencyClient;
import com.gatkowski.nbpapispring.currency.CurrencyService;
import com.gatkowski.nbpapispring.currency.NBPRates;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class CurrencyTest {

    @Autowired
    CurrencyClient currencyClient;

    @Autowired
    CurrencyService currencyService;

    @Test
    void shouldReturnSingleValue() {
        Mono<NBPRates> averageGoldPrice = currencyClient.queryNbpForExchangeRates("USD", 5);

        StepVerifier
                .create(averageGoldPrice)
                .expectNextCount(1)
                .verifyComplete();
    }

}
