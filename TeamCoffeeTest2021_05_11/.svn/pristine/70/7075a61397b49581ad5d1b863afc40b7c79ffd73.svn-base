package com.teamcoffee.board.controller;

import java.io.File;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.teamcoffee.board.service.BoardService;
import com.teamcoffee.board.service.CommentService;
import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.board.vo.ImgVO;
import com.teamcoffee.util.FileUploadUtil;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Resource(name = "boardService")
	private BoardService boardService;
	@Resource(name = "commentService")
	private CommentService commentService;
	
	// 글쓰기양식 이동
	@GetMapping("/boardWriteForm")
	public String writeForm(String boardCode, Model model) {
		model.addAttribute("boardCode", boardCode);
		return "cafe/board/boardWrite";
	}
	
	// 게시글 업로드
	@PostMapping("/boardUpload")
	public String boardUpload(BoardVO boardVO, MultipartHttpServletRequest multi, ImgVO imgVO) {
		//디비에 게시글 정보를 저장한다.
		boardService.boardUpload(boardVO);
		
		//첨부파일이 있으면 파일을 서버에 업로드한다.
		
		// fileNames : 첨부파일이 들어있는 input 태그의 name값을 가져옴.
		Iterator<String> fileNames = multi.getFileNames();
		
		// 첨부파일이 존재할 경우 while문 실행
		while(fileNames.hasNext()) {
			String inputTagName = fileNames.next();
			
			// 각 첨부파일의 정보 가져오기
			MultipartFile file =  multi.getFile(inputTagName);
			String uploadFileName = FileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
			
			// 경로설정
			String uploadPath = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\event\\";
			
			if(inputTagName.equals("mainImg")) {
				imgVO.setBoardImgIsMain("Y");
			}
			else {
				imgVO.setBoardImgIsMain("N");
			}
			
			try {
				file.transferTo(new File(uploadPath + uploadFileName));
				
				int boardNum = boardService.selectMaxBoardNum();
				// 디비에 이미지 정보 저장.
				imgVO.setBoardNum(boardNum);
				imgVO.setBoardUploadImgName(uploadFileName);
				imgVO.setBoardOriginImgName(file.getOriginalFilename());
				
				boardService.insertBoardImg(imgVO);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
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
		boardService.updateViewCnt(boardNum);
		model.addAttribute("board", boardService.boardDetail(boardNum));
		return "cafe/board/community_notice_detail";
	}
	
	// 이벤트 상세보기
	@GetMapping("/eventDetail")
	public String eventDetail(int boardNum, Model model) {
		boardService.updateViewCnt(boardNum);
		model.addAttribute("board", boardService.boardDetail(boardNum));
		return "cafe/board/community_event_detail";
	}

	// 유저게시판 상세보기
	@GetMapping("/userBoardDetail")
	public String userBoardDetail(int boardNum, Model model) {
		boardService.updateViewCnt(boardNum);
		model.addAttribute("board", boardService.boardDetail(boardNum));
		model.addAttribute("commentList", commentService.selectComments(boardNum));
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