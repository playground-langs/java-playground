package com.techzealot.examples.features.sealeds;

public class BlackCat extends Cat {

    @Override
    public String type() {
        return "black " + super.type();
    }
}
