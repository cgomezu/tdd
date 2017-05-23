package com.example.StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by carlgour on 20/05/2017.
 */
public class StringCalculator {

    public int add(String numbers) throws Exception {
        int sum = 0;
        String regexDelimiter = "";
        List<String> delimiters;
        if(containDelimiter(numbers)) {
            String formatDelimiters = "";
            delimiters = getDelimiters(numbers);
            formatDelimiters = getFormatDelimiter(numbers, delimiters, formatDelimiters);
            numbers = numbers.replaceAll("\\/\\/" + formatDelimiters + "\n", "");
        } else {
            delimiters = new ArrayList<>();
            delimiters.add(",");
        }
        String regexDelimiters = getRegexDelimiters(delimiters);
        regexDelimiter = "(\n|" + regexDelimiters + ")";
        if (numbers.length() != 0) {
            String[] splitNumbers = numbers.split(regexDelimiter, numbers.split(regexDelimiter).length);
            try {
                for (int number = 0; number < splitNumbers.length; number++) {
                    sum += toInt(splitNumbers[number]);
                }
            } catch (Exception ex) {
                throw new Exception(ex.getMessage() + getNegatives(splitNumbers));
            }
        }
        return sum;
    }

    private String getRegexDelimiters(List<String> delimiters) {
        String regexDelimiters = "";
        if (delimiters.size() > 1) {
            for (int i = 0; i < delimiters.size(); i++) {
                if(i < delimiters.size() - 1) {
                    regexDelimiters += delimiters.get(i) + "|";
                } else {
                    regexDelimiters += delimiters.get(i);
                }
            }
        } else {
            regexDelimiters += delimiters.get(0);
        }
        return regexDelimiters;
    }

    private String getFormatDelimiter(String numbers, List<String> delimiters, String formatDelimiters) {
        if(containFormatDelimiter(numbers)) {
            if(delimiters.size() > 1) {
                for (String delimiter:  delimiters) {
                    formatDelimiters += "\\[" + delimiter +"\\]";
                }
            } else {
                formatDelimiters += "\\[" + delimiters.get(0) +"\\]";
            }
        } else {
            formatDelimiters += delimiters.get(0);
        }
        return formatDelimiters;
    }

    private String getNegatives(String[] splitNumbers) throws Exception {
        String negatives = "";
        for (int number = 0; number < splitNumbers.length; number++) {
            if (Integer.parseInt(splitNumbers[number]) < 0) {
                negatives += splitNumbers[number] + (number < splitNumbers.length - 1 ? "," : "");
            }
        } return negatives;
    }

    private List<String> getDelimiters(String numbers) {
        List<String> delimiters = new ArrayList<String>();
        if (containFormatDelimiter(numbers)) {
            char[] chars;
            if (containsMultipleDelimiter(numbers)) {
                List<String> delimitersNoFormat = Arrays.asList(numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("\n") - 1).split("\\]\\["));
                for (String delimiter: delimitersNoFormat) {
                    delimiters.add(formatDelimiter(delimiter));
                }
            } else {
                chars = numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("\n") - 1).toCharArray();
                String delimiter = "";
                for (int charIndex = 0; charIndex < chars.length; charIndex++) {
                    delimiter += formatDelimiter(String.valueOf(chars[charIndex]));
                }
                delimiters.add(delimiter);
            }
        } else {
            delimiters.add(numbers.substring(numbers.indexOf("//") + 2, numbers.indexOf("\n")));
        }
        return delimiters;
    }

    private String formatDelimiter(String delimiter) {
        String result = "";
        char[] chars = delimiter.toCharArray();
        for (char c: chars) {
            result += "\\" + c;
        }
        return result;
    }

    private boolean containsMultipleDelimiter(String numbers) {
        return numbers.substring(numbers.indexOf("[") + 1, numbers.indexOf("\n") - 1).contains("][");
    }

    private boolean containFormatDelimiter(String numbers) {
        return numbers.contains("//[");
    }

    private boolean containDelimiter(String numbers) {
        return numbers.indexOf("//") != -1;
    }

    private int toInt(String number) throws Exception {
        int iNumber = Integer.parseInt(number);
        if (iNumber > 1000) {
            iNumber = 0;
        } else if(iNumber < 0) {
            throw new Exception("Negative numbers not allowed: ");
        }
        return iNumber;
    }
}
