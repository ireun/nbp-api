package com.gatkowski.nbpapispring.currency;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("api")
public class CurrencyController {
    private final CurrencyService currencyService;
    @Value("${nbp.currencyNLastDays:5}")
    private int nLastDays;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @Operation(summary = "Get exchange rates for given currency")
    @GetMapping(value = "exchange-rates/{code}", produces = "application/json")
    public Mono<Rates> getRates(@PathVariable String code) {
        return currencyService.getRates(code, nLastDays)
                .onErrorResume(WebClientResponseException.class,
                        ex -> ex.getRawStatusCode() == 404 ? Mono.error(new InvalidCurrencyException()) : Mono.error(ex));
    }

    @ExceptionHandler
    public ResponseEntity<String> handle(InvalidCurrencyException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
