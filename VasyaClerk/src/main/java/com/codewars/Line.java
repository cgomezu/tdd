package com.codewars;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Line {

  public static String Tickets(int[] peopleInLine) {
    if (peopleInLine == null || peopleInLine.length == 0) return "NO";
    int totalInTickets = 0;

    for (int i = 0; i < peopleInLine.length; i++) {
      if (peopleInLine[i] == 25) {
        totalInTickets += 25;
        continue;
      }
      totalInTickets = totalInTickets - (peopleInLine[i] - 25);
      if (totalInTickets <= 0 ) return "NO";
      totalInTickets +=25;
    }
    return "YES";
  }


}
