package com.example.chatserver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
    private UUID id;
    private Long fromId;
    private Long toId;
    private String message;
}
