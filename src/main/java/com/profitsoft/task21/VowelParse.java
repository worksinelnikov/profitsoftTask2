package com.profitsoft.task21;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VowelParse {
    private static final String MASK = "(?!\\*)[uaoei](?!\\*)";

    public String interviewRecursionTest(String string) {
        StringBuilder stringBuilder = new StringBuilder(string);
        Matcher matcher = Pattern.compile(MASK).matcher(stringBuilder);
        if (stringBuilder.length() == 0 || !matcher.find()) {
            if (stringBuilder.charAt(0) == '*') {
                stringBuilder.deleteCharAt(0);
            }
            if (stringBuilder.charAt(stringBuilder.length() - 1) == '*') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
            return stringBuilder.toString();
        }
        int pos = matcher.start();
        stringBuilder.insert(pos, '*');
        stringBuilder.insert(pos + 2, '*');
        String temp = stringBuilder.toString().replaceAll("\\*\\*", "*");
        return interviewRecursionTest(temp);
    }
}
