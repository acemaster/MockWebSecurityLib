package com.jpmorgan.security.controller;

import java.io.Serializable;

public class MockRequestBody implements Serializable {

    private String id;
    private String textBox;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextBox() {
        return textBox;
    }

    public void setTextBox(String textBox) {
        this.textBox = textBox;
    }
}
