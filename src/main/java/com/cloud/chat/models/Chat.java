package com.cloud.chat.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Chats") // Equivalent to DynamoDBTable(tableName = "Chats")
public class Chat {

    @Id // Equivalent to DynamoDBHashKey
    private String roomId;

    private List<Ping> pings; // No need for additional annotations

    public Chat() {
    }

    public Chat(String roomId, List<Ping> pings) {
        this.roomId = roomId;
        this.pings = pings;
    }

    // Getters and setters
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
