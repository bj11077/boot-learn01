package com.fertilizer.back.elastic.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;

@Setter
@Getter
@Document(indexName = "user-topic")
public class User {

    @Id
    private String id;

    private String username;

    private String memberSince;

    private int attendanceCount;

    @Field(name="@timestamp")
    private String regDate;


    public User(String username, String memberSince, int attendanceCount) {
        this.username = username;
        this.memberSince = memberSince;
        this.attendanceCount = attendanceCount;
    }
}
