package com.fertilizer.back.dto.board;

import lombok.Getter;


@Getter
public class BoardDto {

    private String title;
    private String contents;
    private String regId;
    private  String regDate;
    private  int hits;


}
