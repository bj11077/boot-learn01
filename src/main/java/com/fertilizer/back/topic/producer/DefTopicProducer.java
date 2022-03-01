package com.fertilizer.back.topic.producer;

import com.fertilizer.back.topic.config.provider.BaseTopicProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DefTopicProducer extends BaseTopicProducer {

    @Value("${kafka.topic.def}")
    private String topic;


    @Override
    protected String getTopic() {
        return this.topic;
    }


    @Scheduled(fixedDelay = 1000)
    public void sendDef(){
        System.out.println("send def");
//        AbcDto dto = new AbcDto("st",10);
        this.send("ss");
    }




}
