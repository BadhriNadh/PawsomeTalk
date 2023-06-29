package com.cloud.chat.controller;

import com.cloud.chat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @GetMapping("/create/{name}")
    public ResponseEntity<Map<String, Object>> createRoom(@PathVariable("name") String name) {
        Map<String, Object> response = new HashMap<>();
        response.put("roomId", roomService.createRoom());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("join/{roomId}/{name}")
    public ResponseEntity<String> joinRoom(@PathVariable("roomId") String roomId, @PathVariable("name") String name){
        return ResponseEntity.status(HttpStatus.OK).body("Hello");
    }
}
