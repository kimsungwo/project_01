package com.teamcoffee.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamcoffee.member.service.MemberService;
import com.teamcoffee.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Resource(name="memberService")
	private MemberService memberService;
	
	//일반회원 회원가입 페이지 이동
	@GetMapping("/joinMember")
	public String joinMember() {
		return "member/join_form";
	}
	
	//일반회원 회원가입 처리
	@PostMapping("/insertMember")
	public String insertMember(MemberVO memberVO) {
		memberService.insertMember(memberVO);
		return "redirect:/cafe/main";
	}
	
	//일반회원 로그인 처리
	@ResponseBody
	@PostMapping("/memberLoginProcess")
	public MemberVO memberLoginProcess(MemberVO memberVO, HttpSession session) {
		MemberVO result = memberService.memberLoginProcess(memberVO);
		if(result != null) {
			session.setAttribute("memberLoginInfo", result);
		}
		return result;
	}
	
	//로그아웃
	@ResponseBody
	@PostMapping("/logout")
	public void logout(HttpSession session) {
		session.removeAttribute("ownerLoginInfo");
		session.removeAttribute("memberLoginInfo");
	}
	//프로필조회
	@GetMapping("/myPage")
	public String profileManage(MemberVO memberVO, HttpSession session,Model model) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		model.addAttribute("memberInfo",memberService.memberInfo(member));
		return "member/board/profile_manage";
	}
	//프로필조회 개인정보변경
	@PostMapping("/myPageUpdate")
	public String myPageUpdate(MemberVO memberVO, HttpSession session) {
		//System.out.println("!!!!!!" + memberVO.getMemNickname());
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");//최소업데이트실행위해
		memberVO.setMemId(member.getMemId());//아이디세션값 불러오기
	    memberService.myPageUpdate(memberVO);
		return "redirect:/member/myPage";
	}
	
	
	
	//회원탈퇴 페이지 이동
	@GetMapping("/toDropOutForm")
	public String toDropOutForm(MemberVO memberVO, HttpSession session,Model model) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		model.addAttribute("memberInfo",memberService.memberInfo(member));
		return "member/board/to_drop_out";
	}
	//회원탈퇴 실행
	@PostMapping("/toDropOut")
	public String toDropOut(MemberVO memberVO, HttpSession session,Model model) {
		memberService.deleteMember(memberVO);
		session.removeAttribute("memberLoginInfo");
		return "redirect:/cafe/main";
	}
	
	//아이디 찾기페이지 이동
	@GetMapping("/find_idForm")
	public String find_idForm() {
		return "member/find_id";
	}
	
	//아이디 찾기
	@GetMapping("/find_id")
	public String find_id() {
		
		return "member/find_id";
	}
	
	
	
	//비밀번호 찾기
	@GetMapping("/find_pwForm")
	public String find_pwForm() {
		return "member/find_pw";
	}
	
	
	
	
	
	
}



