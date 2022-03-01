package com.fertilizer.back.topic.config.provider;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseTopicProducer {

    @Autowired
    private TopicProducerFactory factory;

    abstract protected String getTopic();

    public void send(Object o){
        this.factory.send(getTopic(),o);
    }

}
