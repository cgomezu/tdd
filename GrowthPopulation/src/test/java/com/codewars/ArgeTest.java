package com.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by carlgour on 26/05/2017.
 */
public class ArgeTest {

    @Test
    public void test1() throws Exception {
        System.out.println("Fixed Tests: nbYear");
        testing(Arge.nbYear(1500, 5, 100, 5000), 15);
        testing(Arge.nbYear(1500000, 2.5, 10000, 2000000), 10);
        testing(Arge.nbYear(1500000, 0.25, 1000, 2000000), 94);
    }
    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }
}
