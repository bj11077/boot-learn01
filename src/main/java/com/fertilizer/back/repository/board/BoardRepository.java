package com.fertilizer.back.repository.board;

import com.fertilizer.back.dto.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board, String> {

    @Override
    List<Board> findAll();
}