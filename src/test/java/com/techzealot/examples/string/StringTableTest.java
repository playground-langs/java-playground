package com.techzealot.examples.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * 字符串常量池测试用例
 */
public class StringTableTest {

    @Test
    public void testIntern1() {
        String s = new String("xxx");
        s.intern();
        String s1 = "xxx";
        assertNotSame(s, s1);
    }

    @Test
    public void testIntern2() {
        String s = new String("xxx");
        String s1 = "xxx";
        s = s.intern();
        assertSame(s, s1);
    }

    @Test
    public void testIntern3() {
        String s = new String("11") + new String("11");
        s.intern();
        String s1 = "1111";
        assertSame(s, s1);
        assertSame(s, s.intern());
    }

    @Test
    public void testIntern4() {
        String s = new String("11") + new String("11");
        String s1 = "1111";
        s.intern();
        assertNotSame(s, s1);
    }

    @Test
    public void testIntern5() {
        String s = new String("1") + new String("1");
        s.intern();
        String s1 = "11";
        assertNotSame(s, s1);
        assertNotSame(s, s.intern());
    }
}
