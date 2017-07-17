package com.codewars;

public class Line {

    public static String tickets(int[] peopleInLine) {
        if (peopleInLine.length == 0) return "NO";

        int totalAmountInQueue = 0;
        int totalIntickets = 0;

        for (int i = 0; i < peopleInLine.length; i++) {
            if (totalIntickets - (peopleInLine[i] - 25) < 0) return "NO";
            totalIntickets += 25;
        }

        return "YES";
    }
}
