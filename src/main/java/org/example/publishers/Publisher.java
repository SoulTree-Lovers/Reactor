package org.example.publishers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Publisher {

    // Flux: 여러 값
    public Flux<Integer> startFlux() {
        return Flux.range(1, 10).log();
    }

    // Mono: 단일 값
    public Mono<Integer> startMono() {
        return Mono.just(1).log();
    }

    public Mono<?> startMonoEmpty() {
        return Mono.empty().log();
    }
}
