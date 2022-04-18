package com.techzealot.examples.features.vectors;

import jdk.incubator.vector.FloatVector;

public abstract class VectorUtils {

    public static float multi(float[] a, float[] x) {
        FloatVector va = FloatVector.fromArray(FloatVector.SPECIES_128, a, 0);
        FloatVector vx = FloatVector.fromArray(FloatVector.SPECIES_128, x, 0);
        float[] y = va.mul(vx).toArray();
        float r = 0F;
        for (float v : y) {
            r += v;
        }
        return r;
    }

    public static void main(String[] args) {
        float[] a = {0.6F, 0.7F, 0.8F, 0.9F};
        float[] x = {1.0F, 2.0F, 3.0F, 4.0F};
        System.out.println(VectorUtils.multi(a,x));
    }
}
