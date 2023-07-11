package com.cloud.chat.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.time.Instant;
import java.util.Date;

@DynamoDBDocument
public class Ping {
    @DynamoDBAttribute
    private String senderName;
    @DynamoDBAttribute
    private String message;
    @DynamoDBAttribute
    private String language;
    @DynamoDBAttribute
    private Date timeStamp;

    public Ping(){}
    public Ping(String senderName, String message, String language, Date timeStamp) {
        this.senderName = senderName;
        this.message = message;
        this.language = language;
        this.timeStamp = timeStamp;
    }

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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
