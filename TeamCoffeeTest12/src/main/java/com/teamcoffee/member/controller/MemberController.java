package com.teamcoffee.member.controller;


import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamcoffee.like.service.LikeService;
import com.teamcoffee.member.service.MemberService;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.util.sha256;


@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	@Resource(name = "likeService")
	private LikeService likeService;
	
	@Autowired
	private JavaMailSender emailSender;
	
	//일반회원 회원가입 페이지 이동
	@GetMapping("/joinMember")
	public String joinMember() {
		return "member/join_form";
	}
	
	//아이디 중복확인
	@ResponseBody
	@PostMapping("/memIdCheck")
	public String memIdCheck(MemberVO memberVO) {
		String result = memberService.memIdCheck(memberVO);
		return result;
	}
	
	//이메일 중복확인
	@ResponseBody
	@PostMapping("/memEmailCheck")
	public String memEmailCheck(MemberVO memberVO) {
		String result = memberService.memEmailCheck(memberVO);
		return result;
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
		String salt = memberService.getSaltByMemId(memberVO);
		String memPw = memberVO.getMemPw();
		
		memPw = sha256.getEncrypt(memPw, salt);
		memberVO.setMemPw(memPw);
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
	public String profileManage(@RequestParam(name="sideMenu", required = false, defaultValue = "1") String sideMenu, MemberVO memberVO, HttpSession session,Model model) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
	
		model.addAttribute("memberInfo",memberService.memberInfo(member));
		return "member/board/profile_manage";
	}
	//프로필조회 개인정보변경
	@PostMapping("/myPageUpdate")
	public String myPageUpdate(MemberVO memberVO, HttpSession session) {
		
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");//최소업데이트실행위해
		memberVO.setMemId(member.getMemId());//아이디세션값 불러오기
	    memberService.myPageUpdate(memberVO);
		return "member/profile_manage_update_result";
	}
	
	//회원탈퇴 페이지 이동
	@GetMapping("/toDropOutForm")
	public String toDropOutForm(@RequestParam(name="sideMenu", required = false, defaultValue = "5") String sideMenu, MemberVO memberVO, HttpSession session,Model model) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		model.addAttribute("memberInfo",memberService.memberInfo(member));
		return "member/board/to_drop_out";
	}
	//회원탈퇴 실행
	@PostMapping("/toDropOut")
	public String toDropOut(MemberVO memberVO, HttpSession session,Model model) {
		String salt = memberService.getSaltByMemId(memberVO);
		String memPw = memberVO.getMemPw();
		//실행시 잘못된 비밀번호입력시에도 if문타서 세션만 초기화됨
		memPw = sha256.getEncrypt(memPw, salt);
		memberVO.setMemPw(memPw);
		MemberVO result = memberService.memberDropOut(memberVO);
		if(result != null) {
			memberService.deleteMember(memberVO);
			session.removeAttribute("memberLoginInfo");
		}
		else {
			model.addAttribute("memberLoginInfo", result);
		}
		return "member/board/to_drop_out_result";
	}
	
	//아이디 찾기페이지 이동
	@GetMapping("/find_idForm")
	public String find_idForm() {
		 return "member/find_id";
	}
	
	//아이디 찾기
	@PostMapping("/find_id")
	public String find_id(MemberVO memberVO,Model model){
		memberService.find_id(memberVO);
		model.addAttribute("findId",memberService.find_id(memberVO));
		return "member/find_id_result";
	}
	
	//비밀번호 찾기페이지 이동
	@GetMapping("/find_pwForm")
	public String find_pwForm(MemberVO memberVO,Model model) {
		model.addAttribute("memberVO",memberVO);
		return "member/find_pw";
	}
	
	//비밀번호 찾기
	@PostMapping("/find_pw")
	public String find_pw(MemberVO memberVO, Model model) {

		MemberVO memCodeFindResult = memberService.find_pw(memberVO);

		if (memCodeFindResult != null) {

			// 메일 보내기
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper messageHelper;
			try {
				messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("kswoo89@naver.com"); // 보내는사람 생략하거나 하면 정상작동을 안함
				messageHelper.setTo(memberVO.getMemEmail()); // 받는사람 이메일
				messageHelper.setSubject("임시 비밀번호 발급"); // 메일제목은 생략이 가능하다

				String RamdomPassword = memberService.getRamdomPassword();
				memberVO.setMemPw(RamdomPassword);
				memberService.pwUpdate(memberVO);

				String text = "고객님의 임시비밀번호는" + RamdomPassword + "입니다.";
				messageHelper.setText(text, true);
				emailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("findPw", memCodeFindResult);
		return "member/find_pw_result";
	}
	
	@GetMapping("/likeCafeList")
	public String likeCafeList(@RequestParam(name="sideMenu", required = false, defaultValue = "3") String sideMenu, Model model, HttpSession session) {
		model.addAttribute("sideMenu", sideMenu);
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		model.addAttribute("likeCafeList", likeService.likeCafeList(member.getMemCode()));
		return "member/board/like_cafe_list";
	}

}