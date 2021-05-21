package com.teamcoffee.board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamcoffee.board.service.CommentService;
import com.teamcoffee.board.vo.CommentVO;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Resource(name = "commentService")
	private CommentService commentService;
	
	// 유저게시판 댓글 업로드
	@PostMapping("/commentUpload")
	public String commentUpload(CommentVO commentVO, Model model) {
		commentService.commentUpload(commentVO);
		model.addAttribute("boardNum", commentVO.getBoardNum());
		return "redirect:/board/userBoardDetail";
	}
	
	// 댓글 삭제
	@GetMapping("/deleteComment")
	public String deleteComment(String commentCode, int boardNum, Model model) {
		commentService.deleteComment(commentCode);
		model.addAttribute("boardNum", boardNum);
		return "redirect:/board/userBoardDetail";
	}
}