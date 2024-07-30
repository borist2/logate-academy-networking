//package com.example.networkingcourse.config;
//
//import com.example.networkingcourse.handler.BasicWebSocketHandler;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//@Configuration
//@RequiredArgsConstructor
//@EnableWebSocket
//public class WebsocketConfig implements WebSocketConfigurer
//{
//    private final BasicWebSocketHandler basicWebSocketHandler;
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry)
//    {
//        registry.addHandler(basicWebSocketHandler, "/basic-ws")
//                .withSockJS();
//    }
//}
