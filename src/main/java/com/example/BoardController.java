package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller

public class BoardController {
    @RequestMapping("/")
    public String home(){

        return "home";
    }

    @Autowired
    BoardServiceImpl boardService;

    @RequestMapping(value = "board/list", method = RequestMethod.GET)
    public String boardlist(Model model) {
        List<BoardVO> list = boardService.getBoardList(); // 데이터를 가져오는 적절한 메서드 호출
        model.addAttribute("list", list);
        //model.addAttribute("list", boardService.getBoardList());
        return "list";
    }

    @RequestMapping(value = "board/add", method = RequestMethod.GET)
    public String addPost() {
        return "addform";
    }

    @RequestMapping(value="board/addok", method=RequestMethod.POST)
    public String addPostOk(BoardVO vo) {
        if(boardService.insertBoard(vo) == 0)
            System.out.println("데이터 추가 실패 ");
        else
            System.out.println("데이터 추가 성공!!!");
        return "redirect:list";
    }

    @RequestMapping(value = "board/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u", boardVO);
        return "editform";
    }

    @RequestMapping(value = "board/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo) {
        if(boardService.updateBoard(vo) == 0)
            System.out.println("데이터 수정 실패 ");
        else
            System.out.println("데이터 수정 성공!!!");
        return "redirect:list";
    }

    @RequestMapping(value = "board/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id)  {
        if(boardService.deleteBoard(id) == 0)
            System.out.println("데이터 삭제 실패 ");
        else
            System.out.println("데이터 삭제 성공!!!");
        return "redirect:list";
    }

    @RequestMapping(value = "board/view/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u", boardVO);
        return "view";
    }
}