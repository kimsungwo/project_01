package com.teamcoffee.board.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamcoffee.board.service.BoardService;
import com.teamcoffee.board.vo.BoardVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Resource(name = "boardService")
	private BoardService boardService;
	
	//글쓰기양식 이동
	@GetMapping("/boardWriteForm")
	public String writeForm(String boardCode, Model model) {
		model.addAttribute("boardCode", boardCode);
		return "cafe/board/boardWrite";
	}
	
	@PostMapping("/boardUpload")
	public String boardUpload(BoardVO boardVO) {
		boardService.boardUpload(boardVO);
		
		String returnPage = "";
		
		switch (boardVO.getBoardCode()) {
		case "BOARD_1":
		case "BOARD_2":
			returnPage = "redirect:/cafe/community1";
			break;
		case "BOARD_3":
			returnPage = "redirect:/cafe/community2";
			break;
		case "BOARD_4":
			returnPage = "redirect:/cafe/community3";
			break;
		}
		
		return returnPage;
	}
	
	// 공지사항 상세보기
	@GetMapping("/noticeDetail")
	public String noticeDetail(int boardNum, Model model) {
		model.addAttribute("board", boardService.boardDetail(boardNum));
		
		return "cafe/board/community_notice_detail";
	}
	
	// 이벤트 상세보기
	@GetMapping("/eventDetail")
	public String eventDetail(int boardNum, Model model) {
		model.addAttribute("board", boardService.boardDetail(boardNum));
		return "cafe/board/community_event_detail";
	}
		
	// 유저게시판 상세보기
	@GetMapping("/userBoardDetail")
	public String userBoardDetail(int boardNum, Model model) {
		model.addAttribute("board", boardService.boardDetail(boardNum));
		
		return "cafe/board/community_userBoard_detail";
	}
	
	// 게시글 수정 페이지로 이동
	@GetMapping("/updateBoardForm")
	public String updateBoardForm(BoardVO boardVO, Model model) {
		model.addAttribute("board", boardVO);
		return "cafe/board/community_board_update";
	}

	// 게시글 수정
	@PostMapping("/updateBoard")
	public String updateBoard(BoardVO boardVO, Model model) {
		boardService.updateBoard(boardVO);
		model.addAttribute("boardNum", boardVO.getBoardNum());
		return "redirect:/board/eventDetail";
	}
	
	// 공지글 삭제
	@PostMapping("/deleteBoard1")
	public String deleteBoard1(int boardNum) {
		boardService.deleteBoard(boardNum);
		
		return "redirect:/cafe/community1";
	}
	
	// 이벤트글 삭제
	@PostMapping("/deleteBoard2")
	public String deleteBoard2(int boardNum) {
		boardService.deleteBoard(boardNum);
		
		return "redirect:/cafe/community2";
	}
	
	// 유저게시글 삭제
	@PostMapping("/deleteBoard3")
	public String deleteBoard3(int boardNum) {
		boardService.deleteBoard(boardNum);
		
		return "redirect:/cafe/community3";
	}
}