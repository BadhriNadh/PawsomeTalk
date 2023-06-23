package com.cloud.chat.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RoomService {

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
       return generateRandomString(4);
    }
}
