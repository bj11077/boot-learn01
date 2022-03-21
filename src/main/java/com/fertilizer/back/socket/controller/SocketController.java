package com.fertilizer.back.socket.controller;

import com.fertilizer.back.socket.dto.SocketDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class SocketController {



    @MessageMapping("/hello")
    @SendTo("/topic/hi")
    public SocketDto handleSocket(SocketDto message){
        System.out.println("--------guest message--------");
        System.out.println(message);
        return message;
    }

}
