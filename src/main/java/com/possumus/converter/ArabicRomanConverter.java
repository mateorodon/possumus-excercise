package com.possumus.converter;

import com.possumus.exceptions.InvalidArabicNumberException;
import com.possumus.exceptions.InvalidRomanNumberException;

import java.util.LinkedHashMap;
import java.util.Map;

public class ArabicRomanConverter {

    private static final Map<String, Integer> values;
    static {
        values = new LinkedHashMap<>();
        values.put("M", 1000);
        values.put("CM", 900);
        values.put("D", 500);
        values.put("CD", 400);
        values.put("C", 100);
        values.put("XC", 90);
        values.put("L", 50);
        values.put("XL", 40);
        values.put("X", 10);
        values.put("IX", 9);
        values.put("V", 5);
        values.put("IV", 4);
        values.put("I", 1);
    }

    public ArabicRomanConverter(){}

    public static int toArabic(String num){
        if (num == null || num.isEmpty())
            throw new InvalidRomanNumberException("Roman number cannot be null or empty");

        int output = 0;
        int last = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            int val = getValidRomanValue(String.valueOf(c));

            if (val < last)
                output -= val;
            else
                output += val;
            last = val;
        }
        return output;
    }

    private static int getValidRomanValue(String c) {
        Integer val = values.get(c);
        if (val == null) {
            throw new InvalidRomanNumberException("Invalid character: " + c);
        }
        return val;
    }

    public static String toRoman(Integer num) {
        if (num == null || num < 1 || num > 3999) {
            throw new InvalidArabicNumberException("Number must be between 1 and 3999");
        }

        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            String roman = entry.getKey();
            int value = entry.getValue();

            while (num >= value) {
                result.append(roman);
                num -= value;
            }
        }

        return result.toString();
    }
}
