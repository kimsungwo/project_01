package com.teamcoffee.cafe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamcoffee.board.service.BoardService;
import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.cafe.service.CafeService;
import com.teamcoffee.cafe.vo.CafeVO;

@Controller
@RequestMapping("/cafe")
public class CafeController {
	@Resource(name = "cafeService")
	private CafeService cafeService;
	
	//홈페이지 메인
	@GetMapping("/main")
	public String main() {
		return "cafe/main";
	}
	
	//회원가입 종류 선택
	@GetMapping("/selectMemberType")
	public String selectMemberType() {
		return "cafe/select_member_type";
	}
	
	//카페 리스트
	@GetMapping("/cafeList")
	public String cafeList(Model model) {
		model.addAttribute("chainList", cafeService.selectChainList());
		return "cafe/cafe_list";
	}
	
	//카페 선택
	@GetMapping("/selectChain")
	public String selectChain(CafeVO cafeVO) {
		//카페 선택 쿼리 예정
		return "cafe/select_chain";
	}
	
	// 커뮤니티1_공지사항
	@GetMapping("/community1")
	public String community1(Model model) {
		List<BoardVO> noticeList = cafeService.noticeList();
		model.addAttribute("noticeList", noticeList);
		return "cafe/board/community_side_notice";
	}
	
	// 커뮤니티2_이벤트
	@GetMapping("/community2")
	public String community2(Model model) {
		
		return "cafe/board/community_side_event";
	}
	
	//커뮤니티3_이용자게시판
	@GetMapping("/community3")
	public String community3() {
		return "cafe/board/community_side_userBoard";
	}
}
