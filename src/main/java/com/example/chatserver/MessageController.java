package com.example.chatserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
public class MessageController {

    //    private final List<Message> messages;
    private final Map<Long, List<Message>> userMessages;
    private final Map<ChatKey, List<Message>> chatMessages;

    public MessageController() {
        // TODO: think of concurrent variant
        userMessages = new HashMap<>();
        chatMessages = new HashMap<>();
    }


    // Validate
    @PostMapping(value = "/api/v1/message", produces = "application/json")
    public ResponseEntity<CreateMessageResponse> createMessage(@RequestBody @Valid CreateMessageRequest request) {
        // TODO: user exists check - bad request if user not found
        // TODO: exception handler for MethodArgumentNotValidException
        Message msg = new Message(UUID.randomUUID(), request.getFromUserId(), request.getToUserId(), request.getMessage());
        storeMessages(msg);
        return ResponseEntity.ok(new CreateMessageResponse(msg.getId()));
    }

    @GetMapping("/api/v1/message")
    public ResponseEntity<List<Message>> createMessage(@RequestParam(name = "fromId", required = false) Long fromId, @RequestParam(name = "toId") Long toId) {
        // TODO: user exists check - bad request if user not found.-
        // fromId to be made optional, efficient look ups
        if (fromId == null) {
            return ResponseEntity.ok(userMessages.get(toId));
        }
        return ResponseEntity.ok(chatMessages.get(new ChatKey(fromId, toId)));
    }

    private void storeMessages(Message message) {

        // Updating primary table
        List<Message> messages = userMessages
                .computeIfAbsent(message.getToId(), (k) -> new ArrayList<Message>());
        messages.add(message);

        // Updating composite index

        ChatKey chatKey = new ChatKey(message.getFromId(), message.getToId());
        chatMessages.computeIfAbsent(chatKey, (k) -> new ArrayList<>()).add(message);
    }
}
