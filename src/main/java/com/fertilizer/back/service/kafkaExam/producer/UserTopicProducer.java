package com.fertilizer.back.service.kafkaExam.producer;

import com.fertilizer.back.dto.kafkaExam.KafkaExamDto;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class UserTopicProducer {

   @Value("${kafka.bootstrap.server}")
    private String bootStrapServer;

   @Value("${kafka.topic.user}")
    private String topic;

   @Scheduled(fixedDelay = 1000)
   public void send(){
       Properties properties = new Properties();
       properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServer);
       properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
       properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

     KafkaProducer<String, KafkaExamDto> producer = new KafkaProducer<String, KafkaExamDto>(properties);
     KafkaExamDto dto = new KafkaExamDto();
     dto.setUserName("ef");
     dto.setMemberSince("2021-01-23 09:00:30");
     dto.setAttendanceCount("3");
       ProducerRecord<String,KafkaExamDto> record = new ProducerRecord<>(topic,dto);
        producer.send(record);
   }



}
