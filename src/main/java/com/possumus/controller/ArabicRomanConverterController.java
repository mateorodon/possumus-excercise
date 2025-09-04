package com.possumus.controller;

import com.possumus.service.ArabicRomanConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ArabicRomanConverterController {

    private final ArabicRomanConverterService converterService;

    public ArabicRomanConverterController(ArabicRomanConverterService service){
        this.converterService = service;
    }

    @GetMapping("/to-roman")
    public String convertToRoman(@RequestParam("number") int number) {
        return converterService.convertToRoman(number);
    }

    @GetMapping("/to-arabic")
    public String convertToArabic(@RequestParam("number") String number) {
        int result = converterService.convertToArabic(number);
        return String.valueOf(result);
    }


}
