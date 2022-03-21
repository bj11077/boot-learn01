package com.fertilizer.back.socket.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocketDto {
    private String attendanceCount;
    private String memberSince;
    private String userName;

    public  SocketDto(){

    }

    public SocketDto(String attendanceCount, String memberSince, String userName){
        this.attendanceCount = attendanceCount;
        this.memberSince = memberSince;
        this.userName = userName;
    }


}
