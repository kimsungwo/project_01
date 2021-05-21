package com.teamcoffee.like.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamcoffee.like.service.LikeService;
import com.teamcoffee.like.vo.LikeVO;
import com.teamcoffee.member.vo.MemberVO;

@Controller
@RequestMapping("/like")
public class LikeController {
	
	@Resource(name = "likeService")
	private LikeService likeService;
	
	@ResponseBody
	@PostMapping("/tolike")
	public int tolike(LikeVO likeVO, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		likeVO.setMemCode(member.getMemCode());
		
		//이미 좋아요가 눌린 상태라면 ture, 좋아요가 없으면 false
		if(likeService.isLikeChecked(likeVO)) {
			likeService.deleteLikeVO(likeVO);
		
			return 0;
		}
		else {
			likeService.insertLikeVO(likeVO);
			
			return 1;
		}
	}
	
	@GetMapping("/dislike")
	public String dislike(LikeVO likeVO, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		likeVO.setMemCode(member.getMemCode());
		likeService.deleteLikeVO(likeVO);
		return "redirect:/member/likeCafeList";
	}
	
	//매장 상세보기의 like cnt 갱신
	@ResponseBody
	@PostMapping("/selectLikeCountToCafeCode")
	public int selectLikeCountToCafeCode(LikeVO likeVO) {
		return likeService.selectLikeCountToCafeCode(likeVO);
	}
}
