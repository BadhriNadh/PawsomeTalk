package com.cloud.chat.Repository;

import com.cloud.chat.models.Chat;
import com.cloud.chat.models.Ping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public MongoRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Chat getRoomChat(String roomId){
        return mongoTemplate.findById(roomId, Chat.class);
    }

    public void createChatRoom(String roomId){
        Chat zeroChat = new Chat(roomId, List.of());
        mongoTemplate.save(zeroChat);
    }

    public void updateChat(String roomId, Ping ping){
        Chat chat = mongoTemplate.findById(roomId, Chat.class);
        chat.getPings().add(ping);
        mongoTemplate.save(chat);
    }
}
