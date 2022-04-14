package com.techzealot.examples.features;

import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthStyleFactory;
import java.util.Optional;

public class OptionalTest {

    @Test
    public void testOptional(){
        var op= Optional.of("A");
        op.ifPresentOrElse(System.out::println,()-> System.out.println("not found"));
        System.out.println(op.orElseThrow());
    }
}
