package com.techzealot.examples.features;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class ImmutableCollectionFactoryTest {

    @Test
    public void testCollectionFactory() {
        var immutableList = List.of(1, 2, 3, 4, 5, 6);
        System.out.println(immutableList);
        var immutableMap = Map.of(1, "one", 2, "two");
        System.out.println(immutableMap);
    }
}