package org.example.publishers;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Publisher {

    // Flux: 여러 값
    public Flux<Integer> startFlux() {
        return Flux.range(1, 10).log();
    }

    public Flux<String> startFluxList() {
        return Flux.fromIterable(List.of("a", "b", "c", "d")).log();
    }

    // Mono: 단일 값
    public Mono<Integer> startMono() {
        return Mono.just(1).log();
    }

    public Mono<?> startMonoEmpty() {
        return Mono.empty().log();
    }

    public Mono<?> startMonoError() {
        return Mono.error(new Exception("mono error"));
    }


}
