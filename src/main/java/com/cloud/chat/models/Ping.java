package com.cloud.chat.models;

import java.time.Instant;

public record Ping(String roomId, String userName, String message, Instant timeStamp) {
}
