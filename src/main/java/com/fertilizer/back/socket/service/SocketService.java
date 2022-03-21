package com.fertilizer.back.socket.service;

import com.fertilizer.back.socket.dto.SocketDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SocketService {

    @Autowired
    SimpMessagingTemplate template;

//    @Scheduled(fixedDelay = 3000)
    public void sendTest(SocketDto message){
        template.convertAndSend("/topic/hi",message);
    }

    @Scheduled(fixedDelay = 3000)
    public void sendTests(){
        SocketDto message = new SocketDto("123","444","john");
        System.out.println("send to topic hi");
        template.convertAndSend("/topic/hi",message);
    }
}
