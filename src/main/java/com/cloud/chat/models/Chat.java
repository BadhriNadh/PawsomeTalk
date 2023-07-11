package com.cloud.chat.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "Chats")
public class Chat {

    @DynamoDBHashKey(attributeName = "roomId")
    private String roomId;
    @DynamoDBAttribute(attributeName = "pings")
    private List<Ping> pings;

    public Chat() {}
    public Chat(String roomId, List<Ping> pings) {
        this.roomId = roomId;
        this.pings = pings;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<Ping> getPings() {
        return pings;
    }

    public void setPings(List<Ping> pings) {
        this.pings = pings;
    }
}
