package com.practice.board.controller;

import com.practice.board.entity.Board;
import com.practice.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/write")
    public String boardWriteForm() {

        return "boardwrite";
    }
    @PostMapping("/board/writeprocess")
    public String boardWriteProcess(Board board) {

        boardService.write(board);

        return "";
    }
    @GetMapping("/board/list")
    public String boardList(Model model) {

        model.addAttribute("list", boardService.boardList()); // boardList 실행시 반환된 것을 'list'라는 이름으로 받아서 넘긴
        return "boardlist"; //
    }
    @GetMapping("/board/view") // localhost:8080/view?id=1 하면 id값(integer)를 이용해서 게시물을 불러온다
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));
        return "boardview";
    }
    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {

        boardService.boardDelete(id);

        return "redirect:/board/list";
    }
    @GetMapping("/board/modify/{id}")
    public String boardModify (@PathVariable("id") Integer id,Model model) { // pathvariable 은 /modify/{id}로 들어온 부분을 인식해서 id 로 가져온다

        model.addAttribute("board", boardService.boardView(id));
        return "boardmodify";
    }
    @PostMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable("id") Integer id, Board board) {

        Board boardTemp = boardService.boardView(id);
        boardTemp.setTitle(board.getTitle());
        boardTemp.setContent(board.getContent());

        return "redirect:/board/list";
    }
}
//@Controller
//public class BoardController {
//
//    @Autowired
//    private BoardService boardService; // 주입
//    //@GetMapping : 어떤 URL로 접근하는지에 따라 설정
//    //  @GetMapping("/") // localhost:8080/ 이나 8080으로 접속 시 @ResponseBody 를 보여준다 -> Response로 보내줌
//    @GetMapping("/board/write") // localhost:8080/board/write 로 접속시 boardwrite.html을 보여줌
//    public String boardwriteForm() {
//        return "boardwrite"; // boardwrite.html을 리턴해준다
//    }
//    //    @PostMapping("/board/writeprocess") // form에서 보내는 Url과 일치해야한다
//    //    public String boardwriteprocess(String title, String content) {
//    //        System.out.println("게시글 제목 : " + title);
//    //        System.out.println("게시글 내용 : " + content);
//    //        return ""; 이렇게 /board/writeprocess로 보낼때 넘어오는 변수로 바로 받아줘도 되고 아니면 따로 entity패키지에 만들어준 Board클래스를 써도 된다}
//    //    DB에 저장하기 위해서는 repository가 필요하며 이를 위해 패키지를 추가 생성한다
//    @PostMapping("/board/writeprocess")//
//    public String boardwriteprocess(Board board) {
//
//        boardService.write(board); // boardService를 Controller에서 인식하기 위해 @AutoWired를 이용하여 private BoardService 를 정의하고 Injection 받는다
//
//        return "";
//    }
//}

// 이제 8080으로 들어가보면 main() 메소드 결과를 볼 수 있음
// 추후 작업 사항
// db 테이블 생성
// controller 작업
// 서비스, 레포지토리 등 작업