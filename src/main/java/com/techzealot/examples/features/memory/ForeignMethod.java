package com.techzealot.examples.features.memory;

import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.MemoryAccess;
import jdk.incubator.foreign.MemorySegment;
import jdk.incubator.foreign.ResourceScope;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class ForeignMethod {
    //mac暂不支持
    public static void main(String[] args) throws Throwable {
        try (ResourceScope scope = ResourceScope.newConfinedScope()) {
            CLinker cLinker = CLinker.getInstance();
            MemorySegment helloworld = CLinker.toCString("Hello World!\n", scope);
            MethodHandle cPrintf = cLinker.downcallHandle(
                    CLinker.systemLookup().lookup("printf").get(),
                    MethodType.methodType(int.class, MemoryAccess.class),
                    FunctionDescriptor.of(CLinker.C_INT, CLinker.C_POINTER)
            );
            cPrintf.invoke(helloworld.address());
        }
    }
}
