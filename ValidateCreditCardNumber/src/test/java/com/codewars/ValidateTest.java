package com.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidateTest {
    @Test
    public void test891() throws Exception {
        assertEquals(false, Validate.validate("891"));
    }

    @Test
    public void test91() throws Exception {
        assertEquals(true, Validate.validate("91"));
    }

}
