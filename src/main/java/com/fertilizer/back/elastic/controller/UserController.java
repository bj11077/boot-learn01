package com.fertilizer.back.elastic.controller;

import com.fertilizer.back.elastic.data.User;
import com.fertilizer.back.elastic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;


    //모든정보가져옴
    @RequestMapping("/user")
    public List<User> userGet(){
        List<User> userList = StreamSupport.stream(repository.findAll().spliterator(),false).collect(Collectors.toList());
//        List<User> userList = new ArrayList<>();
//        repository.findAll().forEach(userList::add);
        return userList;
    }


    // 엘라스틱 save
    @RequestMapping("/userSave")
    public void userSave(){
        User user = new User("qqqqq","2021-10-11 15:00:00",3);
        repository.save(user);
        //return userList;
    }


    // 날짜로 조회하는거 만들어야됨
    @RequestMapping("/userDateSearch")
    public List<User> userDateSearch(@RequestParam("start") String start, @RequestParam("end") String end) throws ParseException {

//        String start = "2022-01-04 00:00:00.000";
//        String end = "2022-03-05 00:00:00.000";

        //YYYY-MM-DD'T'HH:mm:ssZ

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        return repository.findAllByRegDateBetween(sdf.parse(start), sdf.parse(end));

//       return repository.findAllByRegDateBetween(sdf.parse(start), sdf.parse(end));
//        return repository.findAllByMemberSinceBetween(start, end);


    }


}
