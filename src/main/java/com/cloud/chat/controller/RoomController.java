package com.cloud.chat.controller;

import com.cloud.chat.models.Chat;
import com.cloud.chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/room")
public class RoomController {

    final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/create/{name}")
    public ResponseEntity<Map<String, String>> createRoom(@PathVariable("name") String name) {
        Map<String, String> response = new HashMap<>();
        response.put("roomId", roomService.createRoom());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("join/{roomId}")
    public ResponseEntity<Map<String, String>> joinRoom(@PathVariable("roomId") String roomId){
        Map<String, String> response = new HashMap<>();

        if(roomService.joinRoom(roomId)) {
            response.put("roomId", roomId);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else {
            response.put("roomId", null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @GetMapping("get/{roomId}")
    public ResponseEntity<Chat> getRoom(@PathVariable("roomId") String roomId){
        return ResponseEntity.status(HttpStatus.OK).body(roomService.getRoomChat(roomId));
    }
}
