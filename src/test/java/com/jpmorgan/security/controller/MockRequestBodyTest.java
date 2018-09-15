package com.jpmorgan.security.controller;

import org.junit.Test;

import static org.junit.Assert.*;

public class MockRequestBodyTest {

    @Test
    public void testObject() {
        MockRequestBody mockRequestBody = new MockRequestBody();
        mockRequestBody.setId("123");
        mockRequestBody.setTextBox("123");
        assertEquals(mockRequestBody.getId(),"123");
        assertEquals(mockRequestBody.getTextBox(),"123");
    }

}