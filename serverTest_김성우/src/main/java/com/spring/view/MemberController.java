package com.spring.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.MemberService;
import com.spring.vo.MemberVO;

@Controller
@RequestMapping (value = "/member")
public class MemberController {
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	
	@GetMapping(value = "/login") 
	public String goLoginForm() {
		return "login";
	}
	//회원가입양식페이지
	@GetMapping(value = "/join") 
	public String joinForm() {
		return "join_form";
	}
	
	//회원가입하는페이지
	//커맨드객체
	//컨트롤러의 메소드의 매개변수로 지정된 객체
	//커맨드객체의 setter 호출로 데이터를 자동으로 받아옴
	//ex) setMemberId();
	@PostMapping(value = "/join") 
	public String join(MemberVO memberVO) {
		System.out.println(memberVO);
		memberService.insertMember(memberVO);
		return "login";
	}
	
	@PostMapping(value="/login")
	public String login(MemberVO memberVO, HttpSession session) {
		MemberVO member =  memberService.login(memberVO);
		if(member != null) {
			session.setAttribute("loginInfo", member); 
		}
		return "login_result";
	}
}
