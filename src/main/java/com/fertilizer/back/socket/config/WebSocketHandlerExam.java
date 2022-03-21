//package com.fertilizer.back.socket.config;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class WebSocketHandlerExam extends TextWebSocketHandler {
//
//    private static List<WebSocketSession> list = new ArrayList<>();
//
//    @Override
//    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        String input = message.getPayload();
//        System.out.println("채팅로그 : "+input);
//        list.forEach(s -> {
//            try {
//                s.sendMessage(message);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//    }
//
//    // 접속후
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        list.add(session);
//        System.out.println("클라이언트 접속: " + session);
//    }
//
//    // 연결해제후
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        list.remove(session);
//        System.out.println("클라이언트 해제 ~  " + session);
//    }
//}
