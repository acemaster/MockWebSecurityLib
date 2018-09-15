package com.jpmorgan.security.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/testing")
public class FilterController {

    @PostMapping
    public ResponseEntity getTestData(@RequestBody MockRequestBody mockRequestBody) {
        return ResponseEntity.ok(String.format("<h1>Testing worked</h1><p>id: %s </p><p>Value: %s</p>",mockRequestBody.getId(),mockRequestBody.getTextBox()));
    }
}
