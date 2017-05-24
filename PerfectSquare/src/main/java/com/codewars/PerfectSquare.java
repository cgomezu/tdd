package com.codewars;

/**
 * Created by carlgour on 24/05/2017.
 */
public class PerfectSquare {

    /*
     * Solution with best practice
     */
    public static long findNextSquare(long sq) {
        long root = (long) Math.sqrt(sq);
        return root * root == sq ? (root + 1) * (root + 1) : -1;
    }

    /*
     * My Solution
     */
//    public static long findNextSquare(long sq) {
//        return calculatePerfectSquare(sq);
//    }

    private static long calculatePerfectSquare(long sq) {
        long result = -1;
        if(isPerfectSquare(sq)) {
            result = Math.round(Math.pow(nextSquare(sq), 2));
        }
        return result;
    }

    private static boolean isPerfectSquare(long sq) {
        return Math.pow(Math.round(Math.sqrt(sq)), 2) == sq;
    }

    private static double nextSquare(long perfectSq) {
        return Math.sqrt(perfectSq) + 1;
    }
}
