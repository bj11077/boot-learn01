package com.fertilizer.back.dto.board;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="free_board")
@Data
public class Board {
    @Id
    private String title;

    private String contents;

    private String regId;

    private String regDate;

    private int hits;

}
