package com.example.networkingcourse.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Service
@Slf4j
public class BasicWebSocketHandler extends TextWebSocketHandler
{
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception
    {
        log.info("Received web socket message [{}]", message.getPayload());

        session.sendMessage(new TextMessage("Response for: " + message.getPayload()));
    }
}
