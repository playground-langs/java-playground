package com.techzealot.examples.features.vectors;

public class FloatUtils {

    public static float multi(float[] a, float[] x) {
        float r = 0F;
        for (int i = 0; i < a.length; i++) {
            r += a[i] * x[i];
        }
        return r;
    }
}
