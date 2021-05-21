package com.teamcoffee.admin.admincontroller;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.teamcoffee.admin.service.AdminService;
import com.teamcoffee.admin.vo.AdminVO;
import com.teamcoffee.cafe.service.CafeService;
import com.teamcoffee.menu.service.MenuService;
import com.teamcoffee.owner.vo.OwnerVO;
import com.teamcoffee.util.sha256;


public class AdminController {

	@Resource(name = "adminService")
	private AdminService adminService;
	
	@Resource(name = "cafeService")
	private CafeService cafeService;
	
	@Resource(name = "menuService")
	private MenuService menuService;
	
	/*
	@Autowired private JavaMailSender emailSender;
	 */
	
	

	
	
	
	
	//관리자 페이지 메인
	@GetMapping("/admin")
	public String admin() {
		return "admin/admin_main";
	}
	
	//멤버 확인 페이지
	@GetMapping("/memberManage")
	public String memberManage() {
		return "owner/board/member_manage";
	}
	
	//멤버 확인 페이지 검색결과
	@GetMapping("/memberManageResult")
	public String memberManageResult(HttpSession session,Model model, AdminVO adminViewVO) {
		if(adminViewVO.getMemCode().equals("owner")) {
			model.addAttribute("ownerList",adminService.selectOwnerList(adminViewVO));
		}
		else if(adminViewVO.getMemCode().equals("member")) {
			model.addAttribute("memberList",adminService.selectMemberList(adminViewVO));
		} 
		return "owner/board/member_manage";
	}
	
	
	
	
}
