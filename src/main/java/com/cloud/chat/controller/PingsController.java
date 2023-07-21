package com.cloud.chat.controller;

import com.cloud.chat.models.Ping;
import com.cloud.chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@Controller
public class PingsController {

    final RoomService roomService;

    public PingsController(RoomService roomService) {
        this.roomService = roomService;
    }

    @MessageMapping("/send/{roomId}")
    @SendTo("/group-dots-ui/receive/{roomId}")
    public Ping message(@DestinationVariable String roomId, Ping ping) {

        return roomService.savePing(roomId, ping);
    }
}
