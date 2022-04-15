package com.techzealot.examples.features;

import com.google.common.base.Strings;

public class MyStrings {

    public String repeat(String string, int count) {
        return Strings.repeat(string, count);
    }

    private String repeatPrivate(String string, int count) {
        return Strings.repeat(string, count);
    }

    public static String repeatStatic(String string, int count) {
        return Strings.repeat(string, count);
    }
}
