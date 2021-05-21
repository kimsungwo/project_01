package com.teamcoffee.owner.controller;


import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.teamcoffee.cafe.service.CafeService;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.menu.service.MenuService;
import com.teamcoffee.owner.service.OwnerService;
import com.teamcoffee.owner.vo.OwnerVO;
import com.teamcoffee.util.FileUploadUtil;

@Controller
@RequestMapping("/owner")
public class OwnerController {
	
	@Resource(name = "ownerService")
	private OwnerService ownerService;
	
	@Resource(name = "cafeService")
	private CafeService cafeService;
	
	@Resource(name = "menuService")
	private MenuService menuService;
	
	//매장주 페이지 메인
	@GetMapping("/main")
	public String main() {
		return "owner/main";
	}
	
	//매장주 회원가입 페이지 이동
	@GetMapping("/joinOwner")
	public String joinOwner() {
		return "owner/join_form";
	}
	
	//매장주 회원가입 처리
	@PostMapping("/insertOwner")
	public String insertOwner(OwnerVO ownerVO) {
		ownerService.insertOwner(ownerVO);
		return "redirect:/cafe/main";
	}
	
	//매장주 로그인 처리
	@ResponseBody
	@PostMapping("/ownerLoginProcess")
	public OwnerVO ownerLoginProcess(OwnerVO ownerVO, HttpSession session) {
		OwnerVO result = ownerService.ownerLoginProcess(ownerVO);
		if(result != null) {
			session.setAttribute("ownerLoginInfo", result);
		}
		return result;
	}
	
	//매장주 프로필 관리 페이지
	@GetMapping("/myPage")
	public String profileManage(@RequestParam(name="sideMenu", required = false, defaultValue = "1") String sideMenu, HttpSession session, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("ownerInfo", ownerService.selectOwnerInfo(owner));
		return "owner/board/profile_manage";
	}
	
	//매장 등록 페이지
	@GetMapping("/regCafe")
	public String regCafe(@RequestParam(name="sideMenu", required = false, defaultValue = "2") String sideMenu, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("chainList", cafeService.selectChainList());
		return "owner/board/reg_cafe";
	}
	
	//매장 등록 처리
	@PostMapping("/insertCafe")
	public String insertCafe(CafeVO cafeVO, HttpSession session, MultipartHttpServletRequest multi, Model model) {
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		cafeVO.setOwnerCode(owner.getOwnerCode());
		
		if(multi.getFile("file1") != null) {
			//첨부파일 업로드
			//경로설정
			String path = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\logo\\";
			//input태그에서 file명 받아오기
			MultipartFile file =  multi.getFile("file1");
			
			String fileName = FileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
			cafeVO.setCafeLogo(fileName);
			
			//첨부파일 등록
			try {
				file.transferTo(new File(path + fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ownerService.insertCafe(cafeVO);
		}
		else {
			ownerService.insertCafe(cafeVO);
		}
		
		return "redirect:/owner/regCafe";
	}
	
	//매장 등록시 체인점 선택에 따른 로고 변화
	@ResponseBody
	@PostMapping("/selectChainLogo")
	public String selectChainLogo(CafeChainVO cafeChainVO) {
		String result = ownerService.selectChainLogo(cafeChainVO);
		return result;
	}
	
	//매장 관리 페이지
	@GetMapping("/cafeManage")
	public String cafeManage(@RequestParam(name="sideMenu", required = false, defaultValue = "3") String sideMenu, HttpSession session, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("cafeList", ownerService.CafeInfoList(owner));
		return "owner/board/cafe_manage";
	}
	
	//매장 정보 수정 페이지
	@GetMapping("/goCafeInfoUpdate")
	public String goCafeInfoUpdate(@RequestParam(name="sideMenu", required = false, defaultValue = "3") String sideMenu, CafeVO cafeVO, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("cafeInfo", ownerService.selectCafeInfo(cafeVO));
		return "owner/board/cafe_update_page";
	}
	
	//매장 정보 수정
	@PostMapping("/cafeInfoUpdate")
	public String cafeInfoUpdate(CafeVO cafeVO, MultipartHttpServletRequest multi) {
		
		if(multi.getFile("file1") != null) {
			//첨부파일 업로드
			//경로설정
			String path = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\logo\\";
			//input태그에서 file명 받아오기
			MultipartFile file =  multi.getFile("file1");
			
			String fileName = FileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
			cafeVO.setCafeLogo(fileName);
			
			//첨부파일 등록
			try {
				file.transferTo(new File(path + fileName));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ownerService.cafeInfoUpdate(cafeVO);
		}
		else {
			ownerService.cafeInfoUpdate(cafeVO);
		}
		
		return "redirect:/owner/cafeManage";
	}
	
	//매장 삭제
	@GetMapping("/deleteCafe")
	public String deleteCafe(CafeVO cafeVO) {
		ownerService.deleteCafe(cafeVO);
		return "redirect:/owner/cafeManage";
	}
	
	//메뉴 등록 페이지
	@GetMapping("/regMenu")
	public String regMenu(Model model, HttpSession session) {
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("selectCafeList", menuService.selectOwnersCafeList(owner));
		return "owner/board/reg_menu";
	}
	
	//메뉴 관리 페이지
	@GetMapping("/menuManage")
	public String menuManage(Model model, HttpSession session) {
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("selectCafeList", menuService.selectOwnersCafeList(owner));
		return "owner/board/menu_manage";
	}
	
}