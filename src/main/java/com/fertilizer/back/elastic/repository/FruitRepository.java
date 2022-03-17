package com.fertilizer.back.elastic.repository;

import com.fertilizer.back.elastic.data.Fruit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FruitRepository extends ElasticsearchRepository<Fruit,String> {



//    List<User> findAllByRegDateBetween(long d1, long d2, Sort sort);

//    List<User> findAllByRegDateBetween(String d1, String d2);

    List<Fruit> findAllBySinceBetween(String d1, String d2);





}
