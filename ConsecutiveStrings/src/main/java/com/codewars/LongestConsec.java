package com.codewars;

import static java.util.Comparator.comparing;

/**
 * Created by carlgour on 27/05/2017.
 */
public class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        String longestString = "";
        int n = strarr.length;

        if (!(n == 0 || k > n || k <= 0)) {
            longestString = getNextString(strarr, 0, k);
            for (int i = 0; i < n; i++) {
                if (i + k - 1 < n - 1) {
                    if (longestString.length() < getNextString(strarr, i + 1, k).length()) {
                        longestString = getNextString(strarr, i + 1, k);
                    }
                }
            }
        }
        return longestString;
    }

    private static String getNextString(String[] strarr, int i, int k) {
        String nextString = "";
        for (int j = i; j < i + k; j++) {
            nextString += strarr[j];
        }
        return nextString;
    }
}
