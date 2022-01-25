package com.fertilizer.back;

import com.fertilizer.back.service.kafkaExam.consumer.UserTopicConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FertilizerBackApplication {



    public static void main(String[] args) {
        SpringApplication.run(FertilizerBackApplication.class, args);
    }

}
