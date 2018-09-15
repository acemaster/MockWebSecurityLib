package com.jpmorgan.security.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static junit.framework.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class FilterControllerTest {

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private FilterController filterController;

    @Test
    public void getTestData() throws Exception {
        MockRequestBody mockRequestBody = new MockRequestBody();
        mockRequestBody.setId("123");
        mockRequestBody.setTextBox("Hello<script>test</script>");
        when(objectMapper.writeValueAsString(any(MockRequestBody.class))).thenReturn("{\"id\":\"testing\",\"textBox\":\"Hello<script>test</script>\"}");
        when(objectMapper.readValue(anyString(),eq(MockRequestBody.class))).thenReturn(mockRequestBody);
        ResponseEntity responseEntity = filterController.getTestData(mockRequestBody);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

}