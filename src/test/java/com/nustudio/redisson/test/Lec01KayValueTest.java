package com.nustudio.redisson.test;

import org.junit.jupiter.api.Test;
import org.redisson.api.RBucketReactive;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class Lec01KayValueTest extends BaseTest {


    @Test
    public void keyValueAccessTest() {
        RBucketReactive<String> bucket = client.getBucket("user:1:name");
        Mono<Void> set = bucket.set("anurak");
        Mono<Void> get = bucket.get().doOnNext(System.out::println).then();

        StepVerifier.create(set.concatWith(get)).verifyComplete();

    }
}
