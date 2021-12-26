package com.fertilizer.back.controller.board;


import com.fertilizer.back.dto.board.Board;
import com.fertilizer.back.service.board.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService service;


    @GetMapping
    public List<Board> getAllBoard(){
        System.out.println(service.getAllBoard().get(0).getContents());
       return service.getAllBoard();
    }


}
