package com.fertilizer.back.elastic.controller;

import com.fertilizer.back.elastic.data.Fruit;
import com.fertilizer.back.elastic.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class FruitController {

    @Autowired
    FruitRepository repository;


    //모든정보가져옴
    @RequestMapping("/fruit")
    public List<Fruit> userGet(){
        List<Fruit> userList = StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList());
//        List<User> userList = new ArrayList<>();
//        repository.findAll().forEach(userList::add);
        return userList;
    }


    // 엘라스틱 save
    @RequestMapping("/fruitSave")
    public void userSave(){
        Fruit user = new Fruit("a","2021-03-15 13:00:00",0);
        repository.save(user);
        //return userList;  {"name":"a","since":"2021-03-15 13:00:00", "attendanceCount":0}
    }


    // 날짜로 조회하는거 만들어야됨
    @RequestMapping("/fruitDateSearch")
    public List<Fruit> userDateSearch() throws ParseException {

        String start = "2022-01-04 00:00:00";
        String end = "2022-03-05 00:00:00";


//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");

//       return repository.findAllByRegDateBetween(sdf.parse(start), sdf.parse(end));
        return repository.findAllBySinceBetween(start,end);


    }


}
