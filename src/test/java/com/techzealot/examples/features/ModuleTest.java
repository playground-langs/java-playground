package com.techzealot.examples.features;

import org.junit.jupiter.api.Test;

public class ModuleTest {

    @Test
    public void testGuavaModule() {
        System.out.println(GuavaModule.repeat("A", 10));
    }
}
