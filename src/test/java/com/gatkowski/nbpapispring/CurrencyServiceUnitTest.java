package com.gatkowski.nbpapispring;

import com.gatkowski.nbpapispring.currency.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceUnitTest {

    @Mock
    private CurrencyClient currencyClient;

    @InjectMocks
    private CurrencyService currencyService;

    @Test
    void shouldReturnCorrectAvg() {
        List<NBPRate> nbpRates = Collections.nCopies(5, new NBPRate(LocalDate.now().minusDays(1), new BigDecimal(5)));
        Mono<NBPRates> ratesMono = Mono.just(new NBPRates("USD", nbpRates));

        when(currencyClient.queryNbpForExchangeRates("USD", 5)).thenReturn(ratesMono);

        Mono<Rates> goldMono = currencyService.getRates("USD", 5);

        StepVerifier
                .create(goldMono)
                .expectNextMatches(p -> p.getPair().equals("PLN/USD") && p.getRateList().size() == nbpRates.size())
                .expectComplete()
                .verify();
    }
}