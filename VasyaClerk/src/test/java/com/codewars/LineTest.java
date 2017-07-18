package com.codewars;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LineTest {

    @Test
    public void test1() {assertEquals("YES", Line.tickets(new int[] {25, 25, 50}));
    }

    @Test
    public void test2() {
        assertEquals("NO", Line.tickets(new int []{25, 100}));
    }

    @Test
    public void test3() {
        assertEquals("NO", Line.tickets(new int []{25, 25, 25, 25, 25, 100, 100}));
    }
}
