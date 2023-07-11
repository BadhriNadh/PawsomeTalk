package com.cloud.chat.service;

import com.cloud.chat.Repository.DynamoRepository;
import com.cloud.chat.models.Chat;
import com.cloud.chat.models.Ping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class RoomService {

    @Autowired
    DynamoRepository dynamoRepository;

    private String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    public String createRoom(){
        String roomId = generateRandomString(4);
        //Chat chat = dynamoRepository.getRoomChat(roomId);
        //if(chat == null){
        //    createRoom();
        //}
        dynamoRepository.createChatRoom(roomId);
        return roomId;
    }

    public Chat getRoomChat(String roomId){
        Chat chat = dynamoRepository.getRoomChat(roomId);
        List<Ping> pings = chat.getPings().stream().sorted(Comparator.comparing(Ping::getTimeStamp)).toList();

        return new Chat(roomId, pings);
    }

    public Ping translateAndStore(String roomId, Ping ping){
        dynamoRepository.updateChat(roomId, ping);
        return ping;
    }
}
