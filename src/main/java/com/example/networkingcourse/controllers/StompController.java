package com.example.networkingcourse.controllers;

import com.example.networkingcourse.dto.ChatMessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/chats")
public class StompController
{
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessageDTO chatMessage)
    {
        log.info("Received message [{}]", chatMessage);
    }


    @MessageMapping("/chat.sendMessageWithResponse")
    public String sendMessageWithResponse(@Payload ChatMessageDTO chatMessage)
    {
        return "Response: " + chatMessage.message();
    }

    @MessageMapping("/chat.sendMessageWithResponseOtherTopic")
    @SendTo("/topic/all")
    public String sendMessageWithResponseOtherTopic(@Payload ChatMessageDTO chatMessage)
    {
        return "Response on other topic: " + chatMessage.message();
    }


    @SubscribeMapping("/messages")
    public String subscribeToMessages()
    {
        return "Response on subscribe";
    }

    @PostMapping
    public ResponseEntity<Void> sendMessageToTopic(@RequestBody ChatMessageDTO chatMessageDTO)
    {
        simpMessagingTemplate.convertAndSend("/topic/new-messages", chatMessageDTO);

        return ResponseEntity.ok().build();
    }

}
