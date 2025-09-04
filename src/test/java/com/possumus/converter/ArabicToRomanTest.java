package com.possumus.converter;

import com.possumus.converter.ArabicRomanConverter;
import com.possumus.exceptions.InvalidArabicNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArabicToRomanTest {

    @Test
    void shouldConvertToRoman() {
        assertEquals("I", ArabicRomanConverter.toRoman(1));
        assertEquals("V", ArabicRomanConverter.toRoman(5));
        assertEquals("X", ArabicRomanConverter.toRoman(10));
    }

    @Test
    void shouldConvertSubtractiveArabicNumbers() {
        assertEquals("IV", ArabicRomanConverter.toRoman(4));
        assertEquals("IX", ArabicRomanConverter.toRoman(9));
        assertEquals("XL", ArabicRomanConverter.toRoman(40));
        assertEquals("XC", ArabicRomanConverter.toRoman(90));
    }

    @Test
    void shouldConvertComplexArabicNumbers() {
        assertEquals("MCMXCIV", ArabicRomanConverter.toRoman(1994));
        assertEquals("MMXXV", ArabicRomanConverter.toRoman(2025));
        assertEquals("CDXLIV", ArabicRomanConverter.toRoman(444));
    }

    @Test
    void shouldConvertBorderCases() {
        assertEquals("I", ArabicRomanConverter.toRoman(1)); //min
        assertEquals("MMMCMXCIX", ArabicRomanConverter.toRoman(3999)); //max
    }

    @Test
    void shouldThrowExceptionForInvalidArabicNumbers() {
        assertThrows(InvalidArabicNumberException.class,
                () -> ArabicRomanConverter.toRoman(0));

        assertThrows(InvalidArabicNumberException.class,
                () -> ArabicRomanConverter.toRoman(4000));

        assertThrows(InvalidArabicNumberException.class,
                () -> ArabicRomanConverter.toRoman(null));
    }
}
