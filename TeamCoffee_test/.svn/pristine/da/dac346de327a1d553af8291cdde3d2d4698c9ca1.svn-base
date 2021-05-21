package com.teamcoffee.board.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamcoffee.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Resource(name = "boardService")
	private BoardService boardService;
	
	// 공지사항_글쓰기양식 이동
	@GetMapping("/community1_writeForm")
	public String community1WriteForm() {
		return "cafe/board/community_notice_write";
	}
		
	// 공지사항_게시글 업로드
	@GetMapping("/community1_upload")
	public String community1_upload() {
		return "redirect:/cafe/board/community_side_notice";
	}
}