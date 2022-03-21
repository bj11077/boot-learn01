package com.fertilizer.back.socket.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class StompSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/end-point").setAllowedOrigins("http://192.168.0.13:4200").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //topic : 브로드캐스트   queue : 개인
        registry.enableSimpleBroker("/topic");

       // /tests로 시작하는경로는 messageMapping으로 라우팅
        registry.setApplicationDestinationPrefixes("/test");
    }
}
