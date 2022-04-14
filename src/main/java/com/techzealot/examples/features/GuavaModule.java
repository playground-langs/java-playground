package com.techzealot.examples.features;

import com.google.common.base.Strings;

public abstract class GuavaModule {
    public static String repeat(String string, int count) {
        return Strings.repeat(string, count);
    }
}
