package com.techzealot.examples.features.sealeds;

/**
 * 子类必须选择开放继承(no-sealed)或者不允许继承(final)
 */
public non-sealed class Cat implements Pet {
    @Override
    public String type() {
        return "cat";
    }
}
