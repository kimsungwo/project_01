package com.shop.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.member.service.MemberService;
import com.shop.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Resource(name="memberService") //얘가 받는거임
	private MemberService memberService;
	
	@GetMapping("/join")
	public String joinForm(MemberVO memberVO) {
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(MemberVO memberVO) {  //name에 넣어야됨...
		memberService.insertMember(memberVO);
		return "redirect:/item/itemList";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public boolean login(MemberVO memberVO,HttpSession session) {
		MemberVO result = memberService.login(memberVO);
		if(result!=null) {//로그인성공이라면
			session.setAttribute("loginInfo", result); 
		}
		return result != null ? true : false;
	}
	@ResponseBody
	@PostMapping("/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("loginInfo");
	}
	
	
}
