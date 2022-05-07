package com.techzealot.examples.generic;

public class OneCounter implements Counter {
    @Override
    public int add(int init) {
        return init+1;
    }
}
