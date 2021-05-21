package com.teamcoffee.owner.controller;


import java.io.File;
import java.io.IOException;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.teamcoffee.cafe.service.CafeService;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.menu.service.MenuService;
import com.teamcoffee.menu.vo.MenuOptionGroupVO;
import com.teamcoffee.menu.vo.MenuOptionVO;
import com.teamcoffee.owner.service.OwnerService;
import com.teamcoffee.owner.vo.OwnerVO;
import com.teamcoffee.util.FileUploadUtil;
import com.teamcoffee.util.sha256;

@Controller
@RequestMapping("/owner")
public class OwnerController {
	
	@Resource(name = "ownerService")
	private OwnerService ownerService;
	
	@Resource(name = "cafeService")
	private CafeService cafeService;
	
	@Resource(name = "menuService")
	private MenuService menuService;
	
	@Autowired
	private JavaMailSender emailSender;
	
	//매장주 페이지 메인
	@GetMapping("/main")
	public String main() {
		return "redirect:myPage";
	}
	
	//매장주 회원가입 페이지 이동
	@GetMapping("/joinOwner")
	public String joinOwner() {
		return "owner/join_form";
	}
	
	//아이디 중복확인
	@ResponseBody
	@PostMapping("/ownerIdCheck")
	public String ownerIdCheck(OwnerVO ownerVO) {
		String result = ownerService.ownerIdCheck(ownerVO);
		return result;
	}
	
	//이메일 중복확인
	@ResponseBody
	@PostMapping("/ownerEmailCheck")
	public String ownerEmailCheck(OwnerVO ownerVO) {
		String result = ownerService.ownerEmailCheck(ownerVO);
		return result;
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
		String salt = ownerService.getSaltByOwnerId(ownerVO);
		String ownerPw = ownerVO.getOwnerPw();
		
		ownerPw = sha256.getEncrypt(ownerPw, salt);
		ownerVO.setOwnerPw(ownerPw);
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
	public String regCafe(@RequestParam(name="sideMenu", required = false, defaultValue = "2") String sideMenu, CafeChainVO cafeChainVO, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("chainList", cafeService.selectChainList(cafeChainVO));
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
		//트랜잭션필요
		//ownerService.deleteCafe(cafeVO);
		return "redirect:/owner/cafeManage";
	}
	
	//메뉴 등록 페이지
	@GetMapping("/regMenu")
	public String regMenu(@RequestParam(name="sideMenu", required = false, defaultValue = "4") String sideMenu, Model model, HttpSession session) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("selectCafeList", menuService.selectOwnersCafeList(owner));
		return "owner/board/reg_menu";
	}
	
	//메뉴 관리 페이지
	@GetMapping("/menuManage")
	public String menuManage(@RequestParam(name="sideMenu", required = false, defaultValue = "5") String sideMenu, Model model, HttpSession session) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("selectCafeList", menuService.selectOwnersCafeList(owner));
		return "owner/board/menu_manage";
	}
	
	//옵션그룹 관리 페이지
	@GetMapping("/optionGroupManage")
	public String optionGroupManage(@RequestParam(name="sideMenu", required = false, defaultValue = "5") String sideMenu, Model model, HttpSession session, CafeVO cafeVO, MenuOptionGroupVO menuOptionGroupVO) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("selectCafeList", menuService.selectOwnersCafeList(owner));
		model.addAttribute("cafeInfo", menuService.selectCafeInfoToOption(cafeVO));
		model.addAttribute("optionGroupList", menuService.selectOptionGroupList(menuOptionGroupVO));
		return "owner/board/option_group_manage";
	}
	
	//옵션 관리 페이지
	@GetMapping("/optionManage")
	public String optionManage(@RequestParam(name="sideMenu", required = false, defaultValue = "5") String sideMenu, Model model, MenuOptionVO menuOptionVO) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("optionList", menuService.selectOptionList(menuOptionVO));
		model.addAttribute("selectedMenu", menuService.selectOptionSelectedList(menuOptionVO));
		model.addAttribute("optionGroupType", menuService.selectOptionGroupType(menuOptionVO));
		return "owner/board/option_manage";
	}
	//관리자 페이지 메인
	@GetMapping("/admin")
	public String admin() {
		return "owner/main";
	}
	
	
	
	//------04.28-------
	
	//프로필조회 개인정보변경
	@PostMapping("/myPageUpdate")
	public String myPageUpdate(OwnerVO ownerVO, HttpSession session) {
		
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");//최소업데이트실행위해
		ownerVO.setOwnerId(owner.getOwnerId());//아이디세션값 불러오기
		ownerService.myPageUpdateOwner(ownerVO);
		return "owner/board/profile_manage_update_result";	
	}
	
	
	//회원탈퇴 페이지 이동
	@GetMapping("/toDropOutForm")
	public String toDropOutForm(@RequestParam(name="sideMenu", required = false, defaultValue = "7") String sideMenu, OwnerVO ownerVO, HttpSession session,Model model) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO member = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("memberInfo",ownerService.selectOwnerInfo(ownerVO));
		return "owner/board/to_drop_out";
	}
	//회원탈퇴 실행
	@PostMapping("/toDropOut")
	public String toDropOut(OwnerVO ownerVO, HttpSession session,Model model) {
		String salt = ownerService.getSaltByOwnerId(ownerVO);
		String ownerPw = ownerVO.getOwnerPw();
		//실행시 잘못된 비밀번호입력시에도 if문타서 세션만 초기화됨
		ownerPw = sha256.getEncrypt(ownerPw, salt);
		ownerVO.setOwnerPw(ownerPw);
		OwnerVO result = ownerService.OwnerDropOut(ownerVO);
		if(result != null) {
			ownerService.deleteOwner(ownerVO);
			session.removeAttribute("ownerLoginInfo");
		}
		else {
			model.addAttribute("ownerLoginInfo", result);
		}
		return "owner/board/to_drop_out_result";
	}
	
	//아이디 찾기페이지 이동
		@GetMapping("/find_idForm")
		public String find_idForm() {
			 return "owner/find_id";
		}
		
		//아이디 찾기
		@PostMapping("/find_id")
		public String find_id(OwnerVO ownerVO,Model model){
			OwnerVO findId = ownerService.find_id(ownerVO);
			model.addAttribute("findId",findId);
			return "owner/find_id_result";
		}
		
		//비밀번호 찾기페이지 이동
		@GetMapping("/find_pwForm")
		public String find_pwForm(OwnerVO ownerVO,Model model) {
			model.addAttribute("OwnerVO",ownerVO);
			return "owner/find_pw";
		}
		
		//비밀번호 찾기
		@PostMapping("/find_pw")
		public String find_pw(OwnerVO ownerVO, Model model) {

			OwnerVO ownerCodeFindResult = ownerService.find_pw(ownerVO);

			if (ownerCodeFindResult != null) {

				// 메일 보내기
				MimeMessage message = emailSender.createMimeMessage();
				MimeMessageHelper messageHelper;
				try {
					messageHelper = new MimeMessageHelper(message, true, "UTF-8");
					messageHelper.setFrom("kswoo89@naver.com"); // 보내는사람 생략하거나 하면 정상작동을 안함
					messageHelper.setTo(ownerVO.getOwnerEmail()); // 받는사람 이메일
					messageHelper.setSubject("임시 비밀번호 발급"); // 메일제목은 생략이 가능하다

					String RamdomPassword = ownerService.getRamdomPassword();
					ownerVO.setOwnerPw(RamdomPassword);
					ownerService.pwUpdate(ownerVO);

					String text = "점주님의 임시비밀번호는" + RamdomPassword + "입니다.";
					messageHelper.setText(text, true);
					emailSender.send(message);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
			model.addAttribute("findPw", ownerCodeFindResult);
			return "owner/find_pw_result";
		}
		
		
		
	//------------04.28--------------
	
	
	
	
}