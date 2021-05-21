package com.teamcoffee.board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamcoffee.board.service.BoardService;
import com.teamcoffee.board.service.CommentService;
import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.board.vo.CommentVO;

@Controller
@RequestMapping("/comment")
public class CommentController {
	@Resource(name = "commentService")
	private CommentService commentService;
	@Resource(name = "boardService")
	private BoardService boardService;
	// 댓글 업로드
	@PostMapping("/commentUpload")
	public String commentUpload(CommentVO commentVO, Model model, BoardVO boardVO) {
		commentService.commentUpload(commentVO);
		model.addAttribute("boardNum", commentVO.getBoardNum());
		model.addAttribute("boardCode", "BOARD_4"); // 유저게시판에만 적용
		boardVO.setBoardEdit(true);
		model.addAttribute("boardEdit", boardVO.getBoardEdit());
		return "redirect:/board/boardDetail";
	}
	
	// 댓글 삭제
	@GetMapping("/deleteComment")
	public String deleteComment(CommentVO commentVO, Model model, BoardVO boardVO) {
		commentService.deleteComment(commentVO.getCommentCode());
		model.addAttribute("boardNum", commentVO.getBoardNum()); 
		model.addAttribute("boardCode", "BOARD_4"); // 유저게시판에만 적용
		boardVO.setBoardEdit(true);
		model.addAttribute("boardEdit", boardVO.getBoardEdit());
		return "redirect:/board/boardDetail";
	}
	
	// 대댓글
	
}