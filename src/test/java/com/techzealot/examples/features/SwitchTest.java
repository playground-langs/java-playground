//package com.techzealot.examples.features;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.SortedMap;
//
//public class SwitchTest {
//
//    @Test
//    public void testMultiMatch() {
//        Assertions.assertEquals("workday", dayOfWeek(1));
//        Assertions.assertEquals("weekend", dayOfWeek(6));
//        Assertions.assertEquals("invalid", dayOfWeek(-1));
//        Assertions.assertEquals("invalid", dayOfWeek(8));
//    }
//
//    private String dayOfWeek(int day) {
//        return switch (day) {
//            case 1, 2, 3, 4, 5 -> "workday";
//            case 6, 7 -> "weekend";
//            default -> "invalid";
//        };
//    }
//
//    @Test
//    public void testTypeCast() {
//        convertAndInvoke("string");
//        convertAndInvoke(1);
//        convertAndInvoke(true);
//        convertAndInvoke(1.0);
//    }
//
//    private void convertAndInvoke(Object input) {
//        switch (input) {
//            case String s -> System.out.println(s.toUpperCase());
//            case Integer i -> System.out.println(i + 1);
//            case Boolean b -> System.out.println(!b);
//            default -> System.out.println("unexpected value");
//        }
//    }
//}
