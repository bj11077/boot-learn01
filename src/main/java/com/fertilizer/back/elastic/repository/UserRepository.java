package com.fertilizer.back.elastic.repository;

import com.fertilizer.back.elastic.data.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User,String> {



//    List<User> findAllByRegDateBetween(long d1, long d2, Sort sort);

//    List<User> findAllByRegDateBetween(Date d1, Date d2);
//List<User> findAllByRegDateBetween(String d1, String d2);

    //날짜검색
    List<User> findAllByRegDateBetween(Date d1, Date d2);

    
    List<User> findAllByMemberSinceBetween(String d1, String d2);







}
