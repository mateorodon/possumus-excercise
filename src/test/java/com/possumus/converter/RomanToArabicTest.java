package com.possumus.converter;

import com.possumus.converter.ArabicRomanConverter;
import com.possumus.exceptions.InvalidRomanNumberException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanToArabicTest {

    @Test
    void shouldConvertToArabic(){
        assertEquals(1, ArabicRomanConverter.toArabic("I"));
        assertEquals(2025, ArabicRomanConverter.toArabic("MMXXV"));
        assertEquals(1994, ArabicRomanConverter.toArabic("MCMXCIV"));
        assertEquals(444, ArabicRomanConverter.toArabic("CDXLIV"));
    }

    @Test
    void shouldConvertBorderCases() {
        assertEquals(1, ArabicRomanConverter.toArabic("I"));// min
        assertEquals(3999, ArabicRomanConverter.toArabic("MMMCMXCIX"));//max
    }

    @Test
    void shouldThrowExceptionForEmptyString() {
        assertThrows(InvalidRomanNumberException.class,
                () -> ArabicRomanConverter.toArabic(""));
    }

    @Test
    void shouldThrowExceptionForInvalidCharacters() {
        assertThrows(InvalidRomanNumberException.class,
                () -> ArabicRomanConverter.toArabic("ABC"));
    }

    @Test
    void shouldThrowExceptionForNullInput() {
        assertThrows(InvalidRomanNumberException.class,
                () -> ArabicRomanConverter.toArabic(null));
    }

}
