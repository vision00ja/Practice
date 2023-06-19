package com.practice.board.service;

import com.practice.board.BoardApplication;
import com.practice.board.entity.Board;
import com.practice.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service // 이 서비스를 controller에서 이용하게된다.
public class BoardService {

    @Autowired // dependency injection 을 해준다 -> 스프링에서 자동으로 알아서 객체 생성해준다 (즉, new 연산자 안해도됨)
    private BoardRepository boardRepository;

    //글 작성
    public void write(Board board) {

        boardRepository.save(board); // repository에 Create해주는 로직
    }
    //게시글 리스트 처리
    public List<Board> boardList() {

        return boardRepository.findAll();

    }
    // 클릭 시 특정 게시글 불러오기 -상세페이지
    public Board boardView(Integer id) {

        return boardRepository.findById(id).get();
    }
    // 게시글 삭제
    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }
}
