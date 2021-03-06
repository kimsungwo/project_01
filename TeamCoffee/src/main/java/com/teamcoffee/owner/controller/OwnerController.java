package com.teamcoffee.owner.controller;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import org.springframework.web.util.WebUtils;

import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.cafe.service.CafeService;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.menu.service.MenuService;
import com.teamcoffee.menu.vo.MenuOptionGroupVO;
import com.teamcoffee.menu.vo.MenuOptionVO;
import com.teamcoffee.owner.service.OwnerService;
import com.teamcoffee.owner.vo.OwnerManageViewVO;
import com.teamcoffee.owner.vo.OwnerVO;
import com.teamcoffee.util.DateUtil;
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
	
	//????????? ????????? ??????
	@GetMapping("/main")
	public String main(Model model, HttpSession session) {
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("owners", ownerService.selectOwnerMainVO(owner));
		return "owner/owner_main";
	}
	
	//????????? ???????????? ????????? ??????
	@GetMapping("/joinOwner")
	public String joinOwner() {
		return "owner/join_form";
	}
	
	//????????? ????????????
	@ResponseBody
	@PostMapping("/ownerIdCheck")
	public void ownerIdCheck(OwnerVO ownerVO, HttpServletResponse response) throws IOException {
		int result = ownerService.ownerIdCheck(ownerVO);
		PrintWriter out = response.getWriter();
		if(result == 0) {
			out.print(true);
		}
		else if(result == 1) {
			out.print(false);
		}
	}
	
	//????????? ????????????
	@ResponseBody
	@PostMapping("/ownerEmailCheck")
	public void ownerEmailCheck(OwnerVO ownerVO, HttpServletResponse response) throws IOException {
		int result = ownerService.ownerEmailCheck(ownerVO);
		PrintWriter out = response.getWriter();
		if(result == 0) {
			out.print(true);
		}
		else if(result == 1) {
			out.print(false);
		}
	}
	
	//????????? ???????????? ??????
	@PostMapping("/insertOwner")
	public String insertOwner(OwnerVO ownerVO) {
		ownerService.insertOwner(ownerVO);
		return "redirect:/cafe/main";
	}
	
	//????????? ????????? ??????
	@ResponseBody
	@PostMapping("/ownerLoginProcess")
	public boolean ownerLoginProcess(OwnerVO ownerVO, HttpSession session, HttpServletRequest request, HttpServletResponse response, Model model) {
		String salt = ownerService.getSaltByOwnerId(ownerVO);
		if(salt == null) {
			return false;
		}
		else {
			String ownerPw = ownerVO.getOwnerPw();
			
			ownerPw = sha256.getEncrypt(ownerPw, salt);
			ownerVO.setOwnerPw(ownerPw);
			OwnerVO ownVO = ownerService.ownerLoginProcess(ownerVO);
			
			if(ownVO != null) {
				session.setAttribute("ownerLoginInfo", ownVO);
				
				if(request.getParameter("useCookie") != null) {
					//?????? ??????
					Cookie ownerLoginCookie = new Cookie("ownerLoginCookie", session.getId());
					ownerLoginCookie.setPath("/"); 
					ownerLoginCookie.setMaxAge(60*60*24*7);
					//?????? 
					response.addCookie(ownerLoginCookie);
				}
			}
			//????????? ????????? ????????? ??????
			if(ownerVO.getUseCookie() != null) {
				int amount = 60 * 60 * 24 * 7;
				Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount)); //????????? ???????????? ??????
				ownerService.ownerKeepLogin(ownVO.getOwnerId(), session.getId(), sessionLimit);
			}
			return ownVO != null ? true : false;
		}
	}
	
	//????????????
	@ResponseBody
	@PostMapping("/ownerLogout")
	public void logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		session.removeAttribute("ownerLoginInfo");
		session.invalidate();
		Cookie ownerLoginCookie = WebUtils.getCookie(request, "ownerLoginCookie");
		if(ownerLoginCookie != null) {
			ownerLoginCookie.setPath("/");
			ownerLoginCookie.setMaxAge(0);
			response.addCookie(ownerLoginCookie);
			ownerService.ownerKeepLogin(session.getId(), "none", new Date());
		}
	}
	
	//????????? ????????? ?????? ?????????
	@GetMapping("/myPage")
	public String profileManage(@RequestParam(name="sideMenu", required = false, defaultValue = "1") String sideMenu, HttpSession session, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("ownerInfo", ownerService.selectOwnerInfo(owner));
		return "owner/board/profile_manage";
	}
	
	//?????? ?????? ?????????
	@GetMapping("/regCafe")
	public String regCafe(@RequestParam(name="sideMenu", required = false, defaultValue = "2") String sideMenu, CafeChainVO cafeChainVO, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("chainList", cafeService.selectChainList(cafeChainVO));
		return "owner/board/reg_cafe";
	}
	
	//?????? ?????? ??????
	@PostMapping("/insertCafe")
	public String insertCafe(CafeVO cafeVO, HttpSession session, MultipartHttpServletRequest multi, Model model) {
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		cafeVO.setOwnerCode(owner.getOwnerCode());

		
		if(multi.getFile("file1") != null) {
			//???????????? ?????????
			//????????????
			String path = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\logo\\";
			//input???????????? file??? ????????????
			MultipartFile file =  multi.getFile("file1");
			
			String fileName = FileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
			cafeVO.setCafeLogo(fileName);
			
			//???????????? ??????
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
	
	//?????? ????????? ????????? ????????? ?????? ?????? ??????
	@ResponseBody
	@PostMapping("/selectChainLogo")
	public String selectChainLogo(CafeChainVO cafeChainVO) {
		String result = ownerService.selectChainLogo(cafeChainVO);
		return result;
	}
	
	//?????? ?????? ?????????
	@GetMapping("/cafeManage")
	public String cafeManage(@RequestParam(name="sideMenu", required = false, defaultValue = "3") String sideMenu, HttpSession session, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("cafeList", ownerService.CafeInfoList(owner));
		return "owner/board/cafe_manage";
	}
	
	//?????? ?????? ?????? ?????????
	@GetMapping("/goCafeInfoUpdate")
	public String goCafeInfoUpdate(@RequestParam(name="sideMenu", required = false, defaultValue = "3") String sideMenu, CafeVO cafeVO, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("cafeInfo", ownerService.selectCafeInfo(cafeVO));
		return "owner/board/cafe_update_page";
	}
	
	//?????? ?????? ??????
	@PostMapping("/cafeInfoUpdate")
	public String cafeInfoUpdate(CafeVO cafeVO, MultipartHttpServletRequest multi) {
		
		if(multi.getFile("file1") != null) {
			//???????????? ?????????
			//????????????
			String path = "D:\\workspaceSTS\\TeamCoffee\\src\\main\\webapp\\resources\\img\\logo\\";
			//input???????????? file??? ????????????
			MultipartFile file =  multi.getFile("file1");
			
			String fileName = FileUploadUtil.getNowDateTime() + "_" + file.getOriginalFilename();
			cafeVO.setCafeLogo(fileName);
			
			//???????????? ??????
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
	
	//???????????? ?????? ??????
	@ResponseBody
	@PostMapping("/checkBuyStatusToCafe")
	public boolean checkBuyStatusToCafe(CafeVO cafeVO) {
		return ownerService.checkBuyStatusToCafe(cafeVO);
	}
	
	//?????? ??????
	@ResponseBody
	@PostMapping("/deleteCafe")
	public int deleteCafe(CafeVO cafeVO) {
		 return ownerService.deleteCafe(cafeVO);
	}
	
	//?????? ?????? ?????????
	@GetMapping("/regMenu")
	public String regMenu(@RequestParam(name="sideMenu", required = false, defaultValue = "4") String sideMenu, Model model, HttpSession session) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("selectCafeList", menuService.selectOwnersCafeList(owner));
		return "owner/board/reg_menu";
	}
	
	//?????? ?????? ?????????
	@GetMapping("/menuManage")
	public String menuManage(@RequestParam(name="sideMenu", required = false, defaultValue = "5") String sideMenu, Model model, HttpSession session) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("selectCafeList", menuService.selectOwnersCafeList(owner));
		return "owner/board/menu_manage";
	}
	
	//???????????? ?????? ?????????
	@GetMapping("/optionGroupManage")
	public String optionGroupManage(@RequestParam(name="sideMenu", required = false, defaultValue = "5") String sideMenu, Model model, HttpSession session, CafeVO cafeVO, MenuOptionGroupVO menuOptionGroupVO) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("selectCafeList", menuService.selectOwnersCafeList(owner));
		model.addAttribute("cafeInfo", menuService.selectCafeInfoToOption(cafeVO));
		model.addAttribute("optionGroupList", menuService.selectOptionGroupList(menuOptionGroupVO));
		return "owner/board/option_group_manage";
	}
	
	//?????? ?????? ?????????
	@GetMapping("/optionManage")
	public String optionManage(@RequestParam(name="sideMenu", required = false, defaultValue = "5") String sideMenu, Model model, MenuOptionVO menuOptionVO) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("optionList", menuService.selectOptionList(menuOptionVO));
		model.addAttribute("selectedMenu", menuService.selectOptionSelectedList(menuOptionVO));
		model.addAttribute("optionGroupType", menuService.selectOptionGroupType(menuOptionVO));
		return "owner/board/option_manage";
	}
	
	//??????????????? ??????????????????
	@PostMapping("/myPageUpdate")
	public String myPageUpdate(OwnerVO ownerVO, HttpSession session) {
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");//??????????????????????????????
		ownerVO.setOwnerId(owner.getOwnerId());//?????????????????? ????????????
		ownerService.myPageUpdateOwner(ownerVO);
		return "redirect:/owner/myPage";	
	}
	
	// ???????????? ????????? ??????
	@GetMapping("/toDropOutForm")
	public String toDropOutForm(@RequestParam(name = "sideMenu", required = false, defaultValue = "8") String sideMenu,
			OwnerVO ownerVO, HttpSession session, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO) session.getAttribute("ownerLoginInfo");
		model.addAttribute("memberInfo", ownerService.selectOwnerInfo(owner));
		return "owner/board/to_drop_out";
	}

	// ???????????? ??????
	@PostMapping("/toDropOut")
	public String toDropOut(OwnerVO ownerVO, HttpSession session, Model model) {
		String salt = ownerService.getSaltByOwnerId(ownerVO);
		String ownerPw = ownerVO.getOwnerPw();
		// ????????? ????????? ??????????????????????????? if????????? ????????? ????????????
		ownerPw = sha256.getEncrypt(ownerPw, salt);
		ownerVO.setOwnerPw(ownerPw);
		OwnerVO result = ownerService.OwnerDropOut(ownerVO);
		if (result != null) {
			ownerService.leftOwner(ownerVO);
			session.removeAttribute("ownerLoginInfo");
		} else {
			model.addAttribute("ownerLoginInfo", result);
		}
		return "owner/board/to_drop_out_result2";
	}

	// ????????? ??????????????? ??????
	@GetMapping("/find_idFormOwner")
	public String find_idForm() {
		return "owner/find_id_owner";
	}

	// ????????? ??????
	@PostMapping("/find_idOwner")
	public String find_id(OwnerVO ownerVO, Model model) {
		OwnerVO findId = ownerService.find_idOwner(ownerVO);
		model.addAttribute("findIdOwner", findId);
		return "owner/find_id_owner_result";
	}

	// ???????????? ??????????????? ??????
	@GetMapping("/find_pwFormOwner")
	public String find_pwForm(OwnerVO ownerVO, Model model) {
		model.addAttribute("OwnerVO", ownerVO);
		return "owner/find_pw_owner";
	}

	// ???????????? ??????
	@PostMapping("/find_pw_owner")
	public String find_pw(OwnerVO ownerVO, Model model) {

		OwnerVO ownerCodeFindResult = ownerService.find_pwOwner(ownerVO);

		if (ownerCodeFindResult != null) {

			// ?????? ?????????
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper messageHelper;
			try {
				messageHelper = new MimeMessageHelper(message, true, "UTF-8");
				messageHelper.setFrom("kswoo89@naver.com"); // ??????????????? ??????????????? ?????? ??????????????? ??????
				messageHelper.setTo(ownerVO.getOwnerEmail()); // ???????????? ?????????
				messageHelper.setSubject("?????? ???????????? ??????"); // ??????????????? ????????? ????????????

				String RamdomPassword = ownerService.getRamdomPasswordOwner();
				ownerVO.setOwnerPw(RamdomPassword);
				ownerService.pwUpdateOwner(ownerVO);

				String text = "???????????? ?????????????????????" + RamdomPassword + "?????????.";
				messageHelper.setText(text, true);
				emailSender.send(message);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}
		model.addAttribute("findPwOwner", ownerCodeFindResult);
		return "owner/find_pw_owner_result";
	}
	
	//QnA ?????????
	@GetMapping("/qnaOwner")
	public String qnaOwner(@RequestParam(name = "sideMenu", required = false, defaultValue = "7") String sideMenu, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		return "owner/board/qna_owner";
	}
	
	
	//???????????? ?????????
	@GetMapping("/orderConfirm")
	public String orderConfirm(@RequestParam(name = "sideMenu", required = false, defaultValue = "6") String sideMenu, HttpSession session, Model model, BuyVO buyVO) {
		model.addAttribute("sideMenu", sideMenu);
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		model.addAttribute("selectCafeList", menuService.selectOwnersCafeList(owner));
		buyVO.setPreDate(DateUtil.getOneMonthAgoDate());
		buyVO.setNowDate(DateUtil.getNowDate(DateUtil.PRIMARY_DATE_FORMAT));
		return "owner/board/order_confirm";
	}
	
	//???????????? ????????? ?????? ??????
	@ResponseBody
	@PostMapping("/selectOrderList")
	public List<BuyViewVO> selectOrderList(BuyVO buyVO){
		return ownerService.selectOrderList(buyVO);
	}
	
	//???????????? ????????? ???????????? ??????
	@ResponseBody
	@PostMapping("/renameOrderNames")
	public List<BuyViewVO> renameOrderNames(BuyVO buyVO){
		return ownerService.renameOrderNames(buyVO);
	}
	
	//???????????? ?????? ????????? ?????? ??????
	@ResponseBody
	@PostMapping("/selectCafeCodeToOwner")
	public List<CafeVO> selectCafeCodeToOwner(HttpSession session){
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		return ownerService.selectCafeCodeToOwner(owner);
	}
	
	//????????? ?????? ?????? ??????
	@ResponseBody
	@PostMapping("/checkOrderConfirm")
	public List<BuyViewVO> checkOrderConfirm(HttpSession session) {
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		return ownerService.checkOrderConfirm(owner);
	}
	
	//????????? ???????????? ??????
	@ResponseBody
	@PostMapping("/checkCafeClosed")
	public boolean checkCafeClosed(HttpSession session) {
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		return ownerService.checkCafeClosed(owner);
	}
	
	//?????? ???????????? ??????
	@ResponseBody
	@PostMapping("/updateCafeState")
	public void updateCafeState(CafeVO cafeVO) {
		ownerService.updateCafeState(cafeVO);
	}
	
}
