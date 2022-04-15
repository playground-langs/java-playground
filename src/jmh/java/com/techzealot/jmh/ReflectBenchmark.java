package com.techzealot.jmh;

import com.techzealot.examples.features.MyStrings;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

@State(Scope.Benchmark)//声明类属性的作用域
public class ReflectBenchmark {

    private MyStrings ms = new MyStrings();

    private String string = "AAAAAAAAAA";

    private final int count = 20;

    private Method virtualMethod;
    private Method privateMethod;
    private Method staticMethod;

    private MethodHandle virtualMH;
    private MethodHandle privateMH;
    private MethodHandle staticMH;

    @Setup
    @BeforeAll
    public void prepare() throws Exception {
        virtualMethod = MyStrings.class.getDeclaredMethod("repeat", String.class, int.class);
        privateMethod = MyStrings.class.getDeclaredMethod("repeatPrivate", String.class, int.class);
        privateMethod.setAccessible(true);
        staticMethod = MyStrings.class.getDeclaredMethod("repeatStatic", String.class, int.class);
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType mt = MethodType.methodType(String.class, String.class, int.class);
        virtualMH = lookup.findVirtual(MyStrings.class, "repeat", mt).bindTo(ms);
        staticMH = lookup.findStatic(MyStrings.class, "repeatStatic", mt).bindTo(null);
        privateMH = lookup.unreflect(privateMethod).bindTo(ms);
    }

    @Benchmark
    @Test
    public void testDirectInvokeVirtual() {
        ms.repeat(string, count);
    }

    @Benchmark
    @Test
    public void testDirectInvokeStatic() {
        MyStrings.repeatStatic(string, count);
    }

    @Benchmark
    @Test
    public void testReflectVirtual() throws Exception {
        virtualMethod.invoke(ms, string, count);
    }

    @Benchmark
    @Test
    public void testReflectStatic() throws Exception {
        staticMethod.invoke(null, string, count);
    }

    @Benchmark
    @Test
    public void testReflectPrivate() throws Exception {
        privateMethod.invoke(ms, string, count);
    }

    @Benchmark
    @Test
    public void testMHVirtualInvoke() throws Throwable {
        virtualMH.invoke(string, count);
    }

    @Benchmark
    @Test
    public void testMHVirtualArgs() throws Throwable {
        virtualMH.invokeWithArguments(string, count);
    }

    @Benchmark
    @Test
    public void testMHVirtualExact() throws Throwable {
        String s= (String) virtualMH.invokeExact(string, count);
    }

    @Benchmark
    @Test
    public void testMHPrivate() throws Throwable {
        privateMH.invoke(string, count);
    }

    @Benchmark
    @Test
    public void testMHStatic() throws Throwable {
        staticMH.invoke(string, count);
    }

}
