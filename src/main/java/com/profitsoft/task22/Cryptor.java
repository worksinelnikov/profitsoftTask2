package com.profitsoft.task22;

import java.util.regex.Pattern;

public class Cryptor {
//    public static void main(String[] args) {
//        String string = "Good Night";
//        System.out.println(encode(string));
//        System.out.println(decode(encode(string)));
//    }

    public String encode(String string) {
        char[] chars = string.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            String binaryString = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            String[] temp = binaryString.split("(?<=([0,1]))(?!\\1)");
            stringBuilder.append("|");
            for (String str : temp) {
                stringBuilder.append(str.contains("0") ? "00" : "0");
                stringBuilder.append(" ");
                for (int i = 0; i < str.length(); i++) {
                    stringBuilder.append("0");
                }
                stringBuilder.append(" ");
            }
            stringBuilder.setLength(stringBuilder.length() - 1);
            stringBuilder.append("|");
        }
        return stringBuilder.toString();
    }

    public String decode(String string) {
        String[] temp = string.split(Pattern.quote("|"));
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : temp) {
            String[] splittedString = str.split(" ");
            for (int i = 0; i < splittedString.length - 1; i++) {
                String unit = splittedString[i].length() > 1 ? "0" : "1";
                for (int j = 0; j < splittedString[i + 1].length(); j++) {
                    stringBuilder.append(unit);
                }
                i++;
            }
            stringBuilder.append(" ");
        }
        String[] result = stringBuilder.toString().split(" ");
        StringBuilder stringBuilder1 = new StringBuilder();
        for (String str : result) {
            int bi = binaryToInteger(str);
            char c = (char) bi;
            stringBuilder1.append(c);
        }
        //stringBuilder1.append(" ");
        return stringBuilder1.toString().trim();
    }

    private static Integer binaryToInteger(String binary) {
        char[] numbers = binary.toCharArray();
        int result = 0;
        int count = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] == '1') result += (int) Math.pow(2, count);
            count++;
        }
        return result;
    }
}
