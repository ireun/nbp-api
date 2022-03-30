package com.gatkowski.nbpapispring.gold;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api")
public class GoldController {
    private final GoldService goldService;

    public GoldController(GoldService goldService) {
        this.goldService = goldService;
    }

    @GetMapping(value = "gold", produces = "application/json")
    public Mono<Gold> getRates() {
        return goldService.getRates("14");
    }
}
