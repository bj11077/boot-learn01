package com.fertilizer.back.service.kafkaExam.consumer;

import com.fertilizer.back.dto.kafkaExam.KafkaExamDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Properties;


//싹고쳐야됨

@Component
public class UserTopicConsumer {

    @Value("${kafka.bootstrap.server}")
    private String bootStrapServer;

    @Value("${kafka.topic.user}")
    private String topic;


    @KafkaListener
    public void receive(){
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,JsonSerializer.class.getName());

        KafkaConsumer<String, KafkaExamDto> consumer = new KafkaConsumer<String, KafkaExamDto>(properties);
        consumer.subscribe(Collections.singletonList(topic));

        KafkaExamDto dto;
        ConsumerRecords<String,KafkaExamDto> records = consumer.poll(1000);

        for (ConsumerRecord<String, KafkaExamDto> record : records) {
            dto = record.value();
            System.out.println(dto);
        }


    }



}
