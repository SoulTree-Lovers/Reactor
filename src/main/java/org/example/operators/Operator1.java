package org.example.operators;

import reactor.core.publisher.Flux;

public class Operator1 {

    // map
    public Flux<Integer> fluxMap() {
        return Flux.range(1, 10)
            .map(it -> it * 2)
            .log();
    }

    // filter
    public Flux<Integer> fluxFilter() {
        return Flux.range(1, 10)
            .filter(it -> it > 5)
            .log();
    }

    // take
    public Flux<Integer> fluxFilterTake() {
        return Flux.range(1, 10)
            .filter(it -> it > 5)
            .take(3) // stream 데이터 중 3개만 가져온다.
            .log();
    }

    // flatMap
    public Flux<Integer> fluxFlatMap() {
        return Flux.range(1, 10)
            .flatMap(it -> Flux.range(it * 10, 10))
            .log();
    }

    public Flux<Integer> fluxFlatMapGugu() {
        return Flux.range(1, 9)
            .flatMap(i -> Flux.range(1, 9)
                .map(j -> {
                    System.out.printf("%d * %d = %d\n", i, j, i*j);
                    return i * j;
                })
            );
    }
}
