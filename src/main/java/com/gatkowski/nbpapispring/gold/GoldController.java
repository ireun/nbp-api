package com.gatkowski.nbpapispring.gold;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class GoldController {
    private final GoldService goldService;
    private final GoldClient goldClient;

    public GoldController(GoldService goldService, GoldClient goldClient) {
        this.goldService = goldService;
        this.goldClient = goldClient;
    }

    @GetMapping(value = "gold", produces = "application/json")
    public Mono<Gold> getRates() {
        Flux<NBPGold> nbpGoldFlux = goldClient.queryNbpForGoldPrice(14);
        return goldService.getAverageGoldPrice(nbpGoldFlux, 14);
    }
}
