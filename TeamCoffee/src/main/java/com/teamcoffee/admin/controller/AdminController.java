package com.teamcoffee.admin.controller;

import javax.servlet.http.HttpSession;
import com.teamcoffee.util.DateUtil;

import java.util.List;

import javax.annotation.Resource;
import com.teamcoffee.admin.service.AdminService;
import com.teamcoffee.admin.vo.AdminViewVO;
import com.teamcoffee.admin.vo.QnAViewVO;
import com.teamcoffee.board.service.BoardService;
import com.teamcoffee.board.service.CommentService;
import com.teamcoffee.board.vo.CommentVO;
import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.cafe.service.CafeService;
import com.teamcoffee.menu.service.MenuService;
import com.teamcoffee.owner.vo.OwnerVO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
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
	@GetMapping("/adminMain")
	public String admin(Model model) {
		int memberCount = adminService.selectAllMember();
		int ownerCount = adminService.selectAllOwner();
		int CreateReady = adminService.selectAllCreateReady();
		model.addAttribute("memberCount",memberCount);
		model.addAttribute("ownerCount",ownerCount);
		model.addAttribute("CreateReady",CreateReady);
		return "admin/admin_main";
	}
	//멤버 확인 페이지
	@GetMapping("/memberManage")
	public String memberManage(@RequestParam(name="sideMenu", required = false, defaultValue = "3") String sideMenu,AdminViewVO adminViewVO,Model model,BuyVO buyVO) {
		model.addAttribute("sideMenu", sideMenu);
		adminViewVO.setPreDate(DateUtil.getOneMonthAgoDate());
		adminViewVO.setNowDate(DateUtil.getNowDate(DateUtil.PRIMARY_DATE_FORMAT));
		return "admin/board/member_manage";
	}
	//멤버 확인 페이지 검색결과
//	@GetMapping("/memberManageResult")
//	public String memberManageResult(@RequestParam(name="sideMenu", required = false, defaultValue = "3") String sideMenu,HttpSession session,Model model, AdminViewVO adminViewVO,BuyVO buyVO) {
//		model.addAttribute("sideMenu", sideMenu);
//		if(adminViewVO.getMemCode().equals("owner")) {
//			adminViewVO.setOwnerId(adminViewVO.getSearchText());
//			buyVO.setPreDate(buyVO.getPreDate());
//			buyVO.setNowDate(buyVO.getNowDate());
//			model.addAttribute("buyVO",buyVO);
//			/* model.addAttribute("adminViewVO",adminViewVO.getSearchText()); */
//			model.addAttribute("ownerList",adminService.selectOwnerList(adminViewVO));
//		}
//		else if(adminViewVO.getMemCode().equals("member")) {
//			adminViewVO.setMemId(adminViewVO.getSearchText());
//			buyVO.setPreDate(buyVO.getPreDate());
//			buyVO.setNowDate(buyVO.getNowDate());
//			model.addAttribute("buyVO",buyVO);
//			/* model.addAttribute("adminViewVO",adminViewVO.getSearchText()); */
//			model.addAttribute("memberList",adminService.selectMemberList(adminViewVO));
//		}
//		else {
//		buyVO.setPreDate(DateUtil.getOneMonthAgoDate());
//		buyVO.setNowDate(DateUtil.getNowDate(DateUtil.PRIMARY_DATE_FORMAT));
//		}
//		return "admin/board/member_manage";
//	}
	
	//일반회원 목록 가져오기
	@ResponseBody
	@PostMapping("/selectMemberList")
	public List<AdminViewVO> selectMemberList(AdminViewVO adminViewVO) {
		return adminService.selectMemberList(adminViewVO);
	}
	
	//매장주 목록 가져오기
	@ResponseBody
	@PostMapping("/selectOwnerList")
	public List<AdminViewVO> selectOwnerList(AdminViewVO adminViewVO) {
		return adminService.selectOwnerList(adminViewVO);
	}
	
	//매장주 상세정보
	@ResponseBody
	@PostMapping("/selectOwnerDetail")
	public AdminViewVO selectOwnerDetail(AdminViewVO adminViewVO){
		 return adminService.selectOwnerDetail(adminViewVO);
	}
	//일반회원 상세정보
	@ResponseBody
	@PostMapping("/selectMemberDetail")
	public AdminViewVO selectMemberDetail(AdminViewVO adminViewVO){
		AdminViewVO result = adminService.selectMemberDetail(adminViewVO);
		 result.setGradeName(adminService.selectGradeName(result));
		 return result;
	}   
	
	
	//카페승인페이지
	@GetMapping("/cafeManage")
	public String cafeManage(@RequestParam(name="sideMenu", required = false, defaultValue = "2") String sideMenu,Model model) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("cafeList",adminService.selectCreateReadyList());
		return "admin/board/cafe_manage";
	}
	
	//카페신청매장 상세정보
	@ResponseBody
	@PostMapping("/selectCreateReadyDetail")
	public AdminViewVO selectCreateReadyDetail(Model model,AdminViewVO adminViewVO){
		AdminViewVO cafeResult = adminService.selectCreateReadyDetail(adminViewVO);
		String chainResult = adminService.selectChainName(cafeResult.getChainCode());
		AdminViewVO ownerResult = adminService.selectOwnerInfo(cafeResult.getOwnerCode());
		cafeResult.setOwnerAddr(ownerResult.getOwnerAddr());
		cafeResult.setOwnerAddrDetail(ownerResult.getCafeAddrDetail());
		cafeResult.setOwnerCode(ownerResult.getOwnerCode());
		cafeResult.setOwnerEmail(ownerResult.getOwnerEmail());
		cafeResult.setOwnerId(ownerResult.getOwnerId());
		cafeResult.setOwnerName(ownerResult.getOwnerName());
		cafeResult.setOwnerRegDate(ownerResult.getOwnerRegDate());
		cafeResult.setOwnerTel(ownerResult.getOwnerTel());
		cafeResult.setChainName(chainResult);
		System.out.println(cafeResult.toString());
		System.out.println(chainResult.toString());
		System.out.println(ownerResult.toString());
		model.addAttribute("cafeResult",cafeResult);
		return cafeResult;
		}   
	
	
	//신규카페 승인
	@GetMapping("/newCafe")
	public String newCafe(@RequestParam(name="sideMenu", required = false, defaultValue = "2") String sideMenu,AdminViewVO adminViewVO,Model model) {
		 model.addAttribute("sideMenu", sideMenu);
		 adminService.newCafe(adminViewVO);
		 model.addAttribute("cafeList",adminService.selectCreateReadyList());
		 return "admin/board/cafe_manage";
	}
	
	//QnA 페이지
	@GetMapping("/qnaManage")
	public String qnaManage(@RequestParam(name="sideMenu", required = false, defaultValue = "1") String sideMenu, Model model) {
		model.addAttribute("sideMenu", sideMenu);
		return "admin/board/qna_admin";
	}
	
	//QnA 리스트
	@ResponseBody
	@PostMapping("/selectQnAList")
	public List<QnAViewVO> selectQnAList(QnAViewVO qnaViewVO){
		qnaViewVO.setBoardWriter("");
		return adminService.selectQnAList(qnaViewVO);
	}
	
	//QnA 상세보기
	@GetMapping("/qnaAdminDetail")
	public String qnaAdminDetail(@RequestParam(name="sideMenu", required = false, defaultValue = "1") String sideMenu, Model model, QnAViewVO qnaViewVO) {
		model.addAttribute("sideMenu", sideMenu);
		model.addAttribute("qnaDetail", adminService.selectDetailQnA(qnaViewVO));
		model.addAttribute("commentList", adminService.selectCommentQnA(qnaViewVO));
		return "admin/board/qna_admin_detail";
	}
	
	//QnA 작성
	@PostMapping("/insertQnAComment")
	public String insertQnAComment(CommentVO commentVO, HttpSession session) {
		OwnerVO admin = (OwnerVO)session.getAttribute("ownerLoginInfo");
		commentVO.setCommentWriter(admin.getOwnerName());
		adminService.insertQnAComment(commentVO);
		return "redirect:/admin/qnaAdminDetail?boardNum=" + commentVO.getBoardNum();
	}
}
