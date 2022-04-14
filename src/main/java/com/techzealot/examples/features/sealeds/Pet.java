package com.techzealot.examples.features.sealeds;

/**
 * 只允许Cat,Dog继承
 */
public sealed interface Pet permits Cat,Dog{

    String type();

    /**
     * jdk9开始接口中允许私有方法
     */
    private void newFeature(){

    }
}
