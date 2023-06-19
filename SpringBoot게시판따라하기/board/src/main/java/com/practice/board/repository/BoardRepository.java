package com.practice.board.repository;

import com.practice.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository <Board, Integer> { // generic으로 타입 지정, <엔티티, 지정타입>

}
