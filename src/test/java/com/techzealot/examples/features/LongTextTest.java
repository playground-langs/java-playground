package com.techzealot.examples.features;

import org.junit.jupiter.api.Test;

public class LongTextTest {

    @Test
    public void testLongText() {
        var longText=
                """
                abc
                def
                {
                "a":1,
                "b":"c"
                }
                """;
        System.out.println(longText);
    }
}
