package org.example.operators;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Operator3 {

    // count: 스트림의 개수를 리턴
    public Mono<Long> fluxCount() {
        return Flux.range(1, 10)
            .count();
    }

    // distinct: 중복값을 찾아서 없애줌
    public Flux<String> fluxDistinct() {
        return Flux.fromIterable(
            List.of(
                "a", "a", "b", "c"
            )
        ).distinct()
            .log();
    }


    // reduce: 1, 2, 3, 4, 5 -> 3, 3, 4, 5 -> 6, 4, 5 -> 10, 5 -> 15
    public Mono<Integer> fluxReduce() {
        return Flux.range(1, 10)
            .reduce((i, j) -> i + j)
            .log();
    }


    // groupby
    public Flux<Integer> fluxGroupBy() {
        return Flux.range(1, 10)
            .groupBy(it -> (it % 2 == 0) ? "even" : "odd") // 짝수와 홀수로 그룹화
            .flatMap(group -> group.reduce((i, j) -> i + j)) // 각 그룹의 합을 리턴
            .log();
    }

}
