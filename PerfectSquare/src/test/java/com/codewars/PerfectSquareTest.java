package com.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by carlgour on 24/05/2017.
 */
public class PerfectSquareTest {
    @Test
    public void test1() throws Exception {
        assertEquals(144, PerfectSquare.findNextSquare(121));
    }

    @Test
    public void test2() throws Exception {
        assertEquals(676, PerfectSquare.findNextSquare(625));
    }

    @Test
    public void test3() throws Exception {
        assertEquals(-1, PerfectSquare.findNextSquare(114));
    }
}
