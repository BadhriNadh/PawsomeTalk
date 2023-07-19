package com.cloud.chat.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.cloud.chat.models.Chat;
import com.cloud.chat.models.Ping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DynamoRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public DynamoRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public Chat getRoomChat(String roomId){
        return dynamoDBMapper.load(Chat.class, roomId);
    }

    public void createChatRoom(String roomId){
        Chat zeroChat = new Chat(roomId, List.of());
        dynamoDBMapper.save(zeroChat);
    }

    public void updateChat(String roomId, Ping ping){
        Chat chat = dynamoDBMapper.load(Chat.class, roomId);
        chat.getPings().add(ping);
        dynamoDBMapper.save(chat);
    }
}
