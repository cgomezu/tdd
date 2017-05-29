package com.codewars;

/**
 * Created by carlgour on 27/05/2017.
 */
public class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        String longestString = "";
        if (!(strarr.length == 0 || k > strarr.length || k <= 0)) {
            for (int index = 0; index < strarr.length - k + 1; index++) {
                StringBuilder sb = new StringBuilder();
                for (int i = index; i < index + k; i++) {
                    sb.append(strarr[i]);
                }
                if (longestString.length() < sb.toString().length()) {
                    longestString = sb.toString();
                }
            }
        }
        return longestString;
    }
}
