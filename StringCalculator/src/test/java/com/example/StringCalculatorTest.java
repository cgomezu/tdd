package com.example;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created by carlgour on 20/05/2017.
 */
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @Before
    public void setUp() throws Exception {
        stringCalculator = new StringCalculator();
    }
cd 
    @Test
    public void testAddWithEmptyString() throws Exception {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void testAddWithOneNumber() throws Exception {
        assertEquals(1,stringCalculator.add("1"));
    }

    @Test
    public void testAddWithTwoNumbers() throws Exception {
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void testAddUnknownAmountOfNumbers() throws Exception {
        assertEquals(11, stringCalculator.add("1,2,3,5"));
    }

    @Test
    public void testNewLinesBetweenNumbers() throws Exception {
        assertEquals(22, stringCalculator.add("1\n2,3\n6\n5,5"));
    }

    @Test
    public void testAddWouldBeSupportDifferentDelimiter() throws Exception {
        assertEquals(7,stringCalculator.add("//;\n1;2\n1;3"));
    }

    @Test
    public void testAddNegativeNumbersNotAllowed() throws Exception {
        try {
            stringCalculator.add("//;\n-1;-2");
            fail("Exception expected");
        } catch (Exception ex) {
            assertEquals(ex.getMessage(), "Negative numbers not allowed: -1,-2");
        }
    }

    @Test
    public void testAddIgnoreNumbersGreaterThan1000() throws Exception {
        assertEquals(2,stringCalculator.add("//;\n2;1001"));
    }

    @Test
    public void testAddWithFormatDelimiter() throws Exception {
        assertEquals(6,stringCalculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void testAddWithMultipleDelimiters() throws Exception {
        assertEquals(6, stringCalculator.add("//[*][%]\n1*2%3"));
    }

    @Test
    public void testAddDelimiterWithLengthGreater1NotAllowed() throws Exception {
        assertEquals(6, stringCalculator.add("//[**][%]\n1**2%3"));
    }
}
