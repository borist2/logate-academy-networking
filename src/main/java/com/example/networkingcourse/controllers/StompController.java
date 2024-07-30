package com.example.networkingcourse.controllers;

import com.example.networkingcourse.dto.ChatMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StompController
{
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessageDTO chatMessage)
    {
        log.info("Received message [{}]", chatMessage);
    }


    @MessageMapping("/chat.sendMessageWithResponse")
    public void sendMessageWithReponse(@Payload ChatMessageDTO chatMessage)
    {
        log.info("Received message [{}]", chatMessage);
    }
}
