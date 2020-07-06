package com.projectshadow.xcit.model;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {

    private int statusCode;
    private Map<String, String> messages = new HashMap<>();

    public ErrorResponse() {
    }

    public ErrorResponse(int statusCode, Map<String, String> messages) {
        this.statusCode = statusCode;
        this.messages = messages;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getMessages() {
        return new HashMap<>(this.messages);
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "UserErrorResponse{" +
                "statusCode=" + statusCode +
                ", messages=" + messages +
                '}';
    }
}
