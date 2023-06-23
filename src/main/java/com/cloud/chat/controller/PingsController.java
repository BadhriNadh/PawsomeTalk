package com.cloud.chat.controller;

import com.cloud.chat.models.Ping;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class PingsController {

    @MessageMapping("/send/{roomId}")
    @SendTo("/pawsome-ui/receive/{roomId}")
    public Ping message(Ping ping) {
        return ping ;
    }
}
