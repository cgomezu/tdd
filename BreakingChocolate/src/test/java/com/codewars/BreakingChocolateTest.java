package com.codewars;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by carlgour on 25/05/2017.
 */
public class BreakingChocolateTest {
    @Test
    public void myTests() throws Exception {
        assertEquals(Chocolate.breakChocolate(5, 5), 24);
        assertEquals(Chocolate.breakChocolate(1, 1), 0);
    }
}
