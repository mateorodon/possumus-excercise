package com.possumus.service;

import com.possumus.converter.ArabicRomanConverter;
import org.springframework.stereotype.Service;

@Service
public class ArabicRomanConverterService {

    public String convertToRoman(int number) {
        return ArabicRomanConverter.toRoman(number);
    }

    public int convertToArabic(String roman) {
        return ArabicRomanConverter.toArabic(roman);
    }
}
