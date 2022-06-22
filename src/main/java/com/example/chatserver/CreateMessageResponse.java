package com.example.chatserver;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CreateMessageResponse {
    private UUID messageId;
}
