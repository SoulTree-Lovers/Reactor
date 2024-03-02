package org.example.publishers;

import reactor.core.publisher.Flux;

public class Publisher {

    public Flux<Integer> startFlux() {
        return Flux.range(1, 10);
    }
}
