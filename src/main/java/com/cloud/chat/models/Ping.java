package com.cloud.chat.models;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
public class Ping {
    private String senderName;
    private String message;
    private String language;
    private Instant timeStamp;

    public Ping() {
    }

    public Ping(String senderName, String message, String language, Instant timeStamp) {
        this.senderName = senderName;
        this.message = message;
        this.language = language;
        this.timeStamp = timeStamp;
    }

    // Getters and setters
    // ...

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
}
