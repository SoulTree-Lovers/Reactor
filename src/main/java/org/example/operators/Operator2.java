package org.example.operators;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Operator2 {

    // concatMap: 순서를 보장하는 flatMap 그대신 flatMap보다 느림
    public Flux<Integer> fluxConcatMap() {
        return Flux.range(1, 10)
            .concatMap(it -> Flux.range(it * 10, 10))
            .log();
    }

    // flatMapMany: mono를 flux로 변환
    public Flux<Integer> monoFlatMapMany() {
        return Mono.just(10)
            .flatMapMany(it -> Flux.range(1, it))
            .log();
    }

    // defaultIfEmpty, switchIfEmpty
    public Mono<Integer> defaultIfEmpty() {
        return Mono.just(100)
            .filter(it -> it > 100)
            .defaultIfEmpty(30) // 값이 없다면, 30을 리턴
            .log();
    }

    public Mono<Integer> switchIfEmpty() {
        return Mono.just(100)
            .filter(it -> it > 100)
            .switchIfEmpty(Mono.just(30) // 값이 없다면, 새로운 객체를 만들어서 리턴
                .map(it -> it * 2)
            )
            .log();
    }

    public Mono<Integer> switchIfEmptyError() {
        return Mono.just(100)
            .filter(it -> it > 100)
            .switchIfEmpty(Mono.error(new Exception("값이 없음.."))) // 값이 없다면, 새로운 객체를 만들어서 리턴
            .log();
    }

    // merge / zip
    public Flux<String> fluxMerge() {
        return Flux.merge( // 두 가지의 Flux Stream을 하나로 합침.
            Flux.fromIterable(List.of("a", "b", "d")),
            Flux.just("c")
        ).log();
    }

    public Flux<String> monoMerge() { // Mono를 합치면 Flux 스트림으로 변환됨.
        return Mono.just("a")
            .mergeWith(Mono.just("b"))
            .mergeWith(Mono.just("c"))
            .log();
    }

    public Flux<String> fluxZip() {
        return Flux.zip(
            Flux.just("a", "b", "c"), // (a, d), (b, e), (c, f)로 묶어줌.
            Flux.just("d", "e", "f")  // T1  T2  T1  T2  T1  T2
            )
            .map(it -> it.getT1() + it.getT2())
            .log();
    }

    public Mono<Integer> monoZip() {
        return Mono.zip(
            Mono.just(1),
            Mono.just(2),
            Mono.just(3),
            Mono.just(4)
        ).map(it -> it.getT1() + it.getT2() + it.getT3() + it.getT4())
            .log();
    }
}
