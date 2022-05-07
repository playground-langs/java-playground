package com.techzealot.examples.generic;

import java.util.List;

/**
 * @param <T>
 */
public class MergedCountable<T extends Counter> implements Countable<T> {
    @Override
    public int count(List<T> inputs) {
        int sum=0;
        for (T input : inputs) {
            sum=input.add(sum);
        }
        return sum;
    }
}
