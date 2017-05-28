package com.codewars;

/**
 * Created by carlgour on 26/05/2017.
 */
public class Arge {

    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        while(p0 < p) {
            p0 += p0 * percent / 100 + aug;
            years++;
        }
        return years;
    }
}
