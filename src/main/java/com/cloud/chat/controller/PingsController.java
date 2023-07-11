package com.cloud.chat.controller;

import com.cloud.chat.models.Ping;
import com.cloud.chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PingsController {

    @Autowired
    RoomService roomService;
    @MessageMapping("/send/{roomId}")
    @SendTo("/pawsome-ui/receive/{roomId}")
    public Ping message(@DestinationVariable String roomId, Ping ping) {

        Ping translatedPing = roomService.translateAndStore(roomId, ping);

        return translatedPing ;
    }
}
