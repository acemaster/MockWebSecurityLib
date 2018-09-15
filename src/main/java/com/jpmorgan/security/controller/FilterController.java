package com.jpmorgan.security.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpmorgan.security.lib.SQLUtil;
import com.jpmorgan.security.lib.XSSUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/testing")
public class FilterController {

    Logger logger = LoggerFactory.getLogger(FilterController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity getTestData(@RequestBody MockRequestBody mockRequestBody) {
        try {
            String requestBody = objectMapper.writeValueAsString(mockRequestBody);
            String temp = XSSUtil.stripXSS(requestBody);
            String tempNoSql = SQLUtil.stripSQL(temp);
            mockRequestBody = objectMapper.readValue(tempNoSql,MockRequestBody.class);
        } catch (JsonProcessingException e) {
            logger.info(e.getMessage());
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return ResponseEntity.ok(String.format("<h1>Testing worked</h1><p>id: %s </p><p>Value: %s</p>",mockRequestBody.getId(),mockRequestBody.getTextBox()));
    }
}
