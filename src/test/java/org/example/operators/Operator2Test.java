package org.example.operators;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

class Operator2Test {

    private final Operator2 operator2 = new Operator2();

    @Test
    void fluxConcatMap() {
        StepVerifier.create(operator2.fluxConcatMap())
            .expectNextCount(100)
            .verifyComplete();
    }

    @Test
    void monoFlatMapMany() {
        StepVerifier.create(operator2.monoFlatMapMany())
            .expectNextCount(10)
            .verifyComplete();
    }

    @Test
    void defaultIfEmpty() {
        StepVerifier.create(operator2.defaultIfEmpty())
            .expectNext(30)
            .verifyComplete();
    }

    @Test
    void switchIfEmpty() {
        StepVerifier.create(operator2.switchIfEmpty())
            .expectNext(60)
            .verifyComplete();
    }

    @Test
    void switchIfEmptyError() {
        StepVerifier.create(operator2.switchIfEmptyError())
            .expectError(Exception.class)
            .verify();
    }

    @Test
    void fluxMerge() {
        StepVerifier.create(operator2.fluxMerge())
            .expectNext("a", "b", "d", "c")
            .verifyComplete();
    }

    @Test
    void monoMerge() {
        StepVerifier.create(operator2.monoMerge())
            .expectNext("a", "b", "c")
            .verifyComplete();
    }

    @Test
    void fluxZip() {
        StepVerifier.create(operator2.fluxZip())
            .expectNext("ad", "be", "cf")
            .verifyComplete();
    }

    @Test
    void monoZip() {
        StepVerifier.create(operator2.monoZip())
            .expectNext(10)
            .verifyComplete();
    }
}