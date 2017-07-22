package com.codewars;

import java.util.stream.IntStream;

public class Validate {
    public static boolean validate(String n) {
        int[] numbers = n.chars()
                .map(i -> Character.getNumericValue(i))
                .toArray();

        for (int i = 0; i < numbers.length; i++) {
            if ((numbers.length % 2 != 0 && i % 2 != 0) || (numbers.length % 2 == 0 && i % 2 == 0)) {
                int calc = numbers[i] * 2;
                numbers[i] = calc > 9 ? calc - 9 : calc;
            }
        }
        return  IntStream.of(numbers).sum() % 10 == 0;
    }
}
