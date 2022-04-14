package com.techzealot.examples.features.records;

public record Person(String name, int age) {

    public static boolean onlyStaticFieldAllow = true;

    public void print() {
        System.out.println(this);
    }
}
