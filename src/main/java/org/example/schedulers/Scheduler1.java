package org.example.schedulers;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Scheduler1 {

    public Flux<Integer> fluxMapWithSubscribeOn() {
        return Flux.range(1, 10)
            .map(it -> it * 2)
            .subscribeOn(Schedulers.boundedElastic()) // 특정 스케쥴러를 사용
            .log();
    }

    public Flux<Integer> fluxMapWithPublishOn() {
        return Flux.range(1, 10)
            .map(it -> it + 1)
            .publishOn(Schedulers.boundedElastic())
            .log()
            .publishOn(Schedulers.parallel())
            .log()
            .map(it -> it * 2)
            .log();
    }
}
