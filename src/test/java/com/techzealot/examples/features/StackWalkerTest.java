package com.techzealot.examples.features;

import org.junit.jupiter.api.Test;

public class StackWalkerTest {


    public String getCurrentCallerMethodName() {
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        StackWalker.StackFrame frame = walker.walk((stream) -> stream.skip(1).findFirst().orElse(null));
        return frame == null ? "null" : frame.getMethodName();
    }

    public void printCallStack(){
        StackWalker walker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        walker.forEach((frame)->{
            System.out.println(frame.getClassName()+"#"+frame.getMethodName());
        });
    }

    @Test
    public void testStackWalker(){
        System.out.println(getCurrentCallerMethodName());
        printCallStack();
    }
}
