package com.spring.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.service.SampleService;
import com.spring.vo.SampleVO;

@Controller
@RequestMapping("/sample")
public class SampleController {
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	//로그인창
	@GetMapping("/first")
	public String first() {
		return "first";
	}
	
	//로그인처리
	@PostMapping("/login")
	public String login(SampleVO sampleVO,HttpSession session,Model model) {
		SampleVO result =  sampleService.loginForm(sampleVO);
		if(result!=null) {
			session.setAttribute("loginInfo", result); 
		}
		return  "login_result";
	}
	//멤버리스트조회
	@GetMapping("/boardList")
	public String memberList(SampleVO sampleVO,Model model) {
		model.addAttribute("SampleVO",sampleService.memberList()); 
		return "memberList";
	}
	//관리자페이지로이동
	@GetMapping("/Manage")
	public String Manage() {
		return "Manage";
	}
}
