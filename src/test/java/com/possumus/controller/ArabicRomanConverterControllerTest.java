package com.possumus.controller;

import com.possumus.exceptions.InvalidArabicNumberException;
import com.possumus.exceptions.InvalidRomanNumberException;
import com.possumus.service.ArabicRomanConverterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ArabicRomanConverterController.class)
class ArabicRomanConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ArabicRomanConverterService converterService;

    @Test
    void shouldConvertArabicToRoman() throws Exception {
        when(converterService.convertToRoman(21)).thenReturn("XXI");

        mockMvc.perform(get("/api/to-roman")
                        .param("number", "21"))
                        .andExpect(status().isOk())
                        .andExpect(content().string("XXI"));
    }

    @Test
    void shouldConvertRomanToArabic() throws Exception {
        when(converterService.convertToArabic("XXI")).thenReturn(21);

        mockMvc.perform(get("/api/to-arabic")
                        .param("number", "XXI"))
                        .andExpect(status().isOk())
                        .andExpect(content().string("21"));
    }

    @Test
    void shouldReturnBadRequestForInvalidArabicNumber() throws Exception {
        when(converterService.convertToRoman(0))
                .thenThrow(new InvalidArabicNumberException("Number must be between 1 and 3999"));

        mockMvc.perform(get("/api/to-roman")
                        .param("number", "0"))
                        .andExpect(status().isBadRequest())
                        .andExpect(content().string("Number must be between 1 and 3999"));
    }

    @Test
    void shouldReturnBadRequestForInvalidRomanNumber() throws Exception {
        when(converterService.convertToArabic("ABC"))
                .thenThrow(new InvalidRomanNumberException("Invalid character: A"));

        mockMvc.perform(get("/api/to-arabic")
                        .param("number", "ABC"))
                        .andExpect(status().isBadRequest())
                        .andExpect(content().string("Invalid character: A"));
    }

    @Test
    void shouldReturnBadRequestForMissingParameter() throws Exception {
        mockMvc.perform(get("/api/to-roman"))  //no param
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnBadRequestForInvalidParameterType() throws Exception {
        mockMvc.perform(get("/api/to-roman")
                        .param("number", "abc"))  // wrong type
                        .andExpect(status().isBadRequest());
    }

}
