package com.assignment.entities;

public class Message {

    private String id;
    private String text;

    public Message(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

}
