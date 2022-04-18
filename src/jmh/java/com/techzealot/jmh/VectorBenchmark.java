package com.techzealot.jmh;

import com.techzealot.examples.features.vectors.FloatUtils;
import com.techzealot.examples.features.vectors.VectorUtils;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;

public class VectorBenchmark {

    @Benchmark
    @Test
    //TODO 模块化问题导致无法执行
    public float vectorMulti() {
        float[] a = {0.6F, 0.7F, 0.8F, 0.9F};
        float[] x = {1.0F, 2.0F, 3.0F, 4.0F};
        return VectorUtils.multi(a, x);
    }

    @Benchmark
    @Test
    public float forMulti() {
        float[] a = {0.6F, 0.7F, 0.8F, 0.9F};
        float[] x = {1.0F, 2.0F, 3.0F, 4.0F};
        return FloatUtils.multi(a, x);
    }
}
