package com.techzealot.examples.features.memory;

import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

public class ForeignMemory {
    public static void main(String[] args) {
        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            MemorySegment segment=MemorySegment.allocateNative(4,scope);
            for (int i = 0; i < 4; i++) {
                MemoryAccess.setByteAtOffset(segment,i,(byte) 'A');
            }
            for (int i = 0; i < 4; i++) {
                System.out.println((char)MemoryAccess.getByteAtOffset(segment,i));
            }
        }
    }
}
