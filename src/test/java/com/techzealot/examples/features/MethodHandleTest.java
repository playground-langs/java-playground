package com.techzealot.examples.features;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Test;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.stream.IntStream;

public class MethodHandleTest {

    @Test
    public void testReflect() throws Throwable {
        MyStrings ms = new MyStrings();
        var string = "AAAAA";
        var count = 30;
        MethodHandle methodHandle = MethodHandles.publicLookup()
                .findVirtual(MyStrings.class, "repeat", MethodType.methodType(String.class, String.class, int.class))
                .bindTo(new MyStrings());
        int N = 3000000;
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        stopwatch.start();
        IntStream.range(0, N).forEach((i) -> {
            try {
                //invokeExact必须处理返回值,否则报错返回值类型为void,不匹配
                methodHandle.invoke(string, count);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println(stopwatch.elapsed());
        stopwatch.reset().start();
        IntStream.range(0, N).forEach((i) -> {
            ms.repeat(string, 30);
        });
        stopwatch.stop();
        System.out.println(stopwatch.elapsed());
    }
}
