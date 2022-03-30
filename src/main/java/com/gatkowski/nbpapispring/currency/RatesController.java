package com.gatkowski.nbpapispring.currency;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api")
public class RatesController {
    private final RatesService ratesService;

    public RatesController(RatesService ratesService) {
        this.ratesService = ratesService;
    }

    @GetMapping(value = "exchange-rates/{code}", produces = "application/json")
    public Mono<Rates> getRates(@PathVariable String code) throws ExecutionException, InterruptedException {
        return ratesService.getRates(code, "5");
    }
}
