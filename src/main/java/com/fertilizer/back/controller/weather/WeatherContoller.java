package com.fertilizer.back.controller.weather;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherContoller {

    @RequestMapping("/today")
    public String weather1(){
        return "{\"weather\":\"cloud\"}";
    }
}
