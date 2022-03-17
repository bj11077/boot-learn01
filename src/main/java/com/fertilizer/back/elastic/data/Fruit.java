package com.fertilizer.back.elastic.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Setter
@Getter
@Document(indexName = "fruit-topic")
public class Fruit {

    @Id
    private String id;

    private String name;

    private String since;

    private int attendanceCount;


    public Fruit(String name,String since, int attendanceCount) {
        this.name = name;
        this.since = since;
        this.attendanceCount = attendanceCount;
    }
}
