package com.fertilizer.back.service.board;

import com.fertilizer.back.dto.board.Board;
import com.fertilizer.back.repository.board.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    public List<Board>  getAllBoard(){

        List<Board> boardList = boardRepository.findAll();

        return boardList;
    }


}
