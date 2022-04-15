package com.techzealot.jmh;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
public class ExceptionBenchmark {

    private final String target="test string";

    @Benchmark
    @Test
    public void withException(Blackhole blackhole){
        try {
            blackhole.consume(target.substring(15));
        } catch (Exception e) {
            //just ignore
        }
    }

    @Benchmark
    @Test
    public void noException(Blackhole blackhole){
        try {
            blackhole.consume(target.substring(5));
        } catch (Exception e) {
            //just ignore
        }
    }
}
