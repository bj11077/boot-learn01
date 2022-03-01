package com.fertilizer.back.topic.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestDefConsumer {

    @KafkaListener(topics = "def", containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord message){
        System.out.println("--------def     receive------------");
        System.out.println(message.value());
    }


}
