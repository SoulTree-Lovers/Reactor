package org.example.operators;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class Operator4 {

    // limit
    public Flux<Integer> fluxDelayAndLimit() {
        return Flux.range(1, 10)
            .delaySequence(Duration.ofSeconds(1)) // 1초에 한 번씩 데이터를 전송
            .log()
            .limitRate(2); // 데이터를 한 번에 2개씩 전송
    }

    // sample
    public Flux<Integer> fluxSample() {
        return Flux.range(1, 100)
            .delayElements(Duration.ofMillis(100)) // 샘플링을 위한 0.1초 지연
            .sample(Duration.ofMillis(300)) // 0.3초 동안 받은 데이터 중 일부만 전달
            .log();
    }
}
