package com.fertilizer.back.topic.config.provider;

import com.fertilizer.back.topic.custom.CustomObjectSerializer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Component
public class TopicProducerFactory {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServer;




    Producer<String,Object> producer;

    @PostConstruct
    public void init(){
//        Map<String,Object> props = new HashMap<>();
//        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootStrapServer);
//        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomObjectSerializer.class);
        Properties props = new Properties();
        props.put("key.serializer", StringSerializer.class);
//        props.put("value.serializer", CustomObjectSerializer.class);
        props.put("value.serializer", CustomObjectSerializer.class);

        props.put("bootstrap.servers", bootStrapServer);
        producer = new KafkaProducer<String, Object>(props);

    }


    public void send(String topic, Object obj){
        ProducerRecord<String,Object> data = new ProducerRecord<>(topic,obj);
        producer.send(data);
    }

}
