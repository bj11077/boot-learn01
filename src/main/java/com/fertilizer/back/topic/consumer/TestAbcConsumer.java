package com.fertilizer.back.topic.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TestAbcConsumer {



    @KafkaListener(topics = "abc", containerFactory = "kafkaListenerContainerFactory")
    public void onMessage(ConsumerRecord message){
        System.out.println("--------abc   receive------------");
        System.out.println(message.value());
    }


}
