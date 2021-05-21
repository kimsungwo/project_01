package com.teamcoffee.cafe.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.cafe.service.CafeService;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.like.vo.LikeVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.menu.service.MenuService;
import com.teamcoffee.menu.vo.MenuOptionGroupVO;
import com.teamcoffee.menu.vo.MenuOptionSelectedViewVO;
import com.teamcoffee.menu.vo.MenuOptionViewVO;
import com.teamcoffee.menu.vo.MenuVO;
import com.teamcoffee.menu.vo.MenuViewVO;
import com.teamcoffee.util.GeoDistance;

@Controller
@RequestMapping("/cafe")
public class CafeController {
	
	@Resource(name = "cafeService")
	private CafeService cafeService;
	
	@Resource(name = "menuService")
	private MenuService menuService;
	
	//홈페이지 메인
	@GetMapping("/main")
	public String main() {
		return "cafe/main";
	}
	
	//회원가입 종류 선택
	@GetMapping("/selectMemberType")
	public String selectMemberType() {
		return "cafe/select_member_type";
	}
	
	//카페 리스트
	@RequestMapping("/cafeList")
	public String cafeList(CafeChainVO cafeChainVO ,Model model) {
		model.addAttribute("chainList", cafeService.selectChainList(cafeChainVO));
		return "cafe/cafe_list";
	}
	
	//카페 선택
	@RequestMapping("/selectChain")
	public String selectChain(CafeChainVO cafeChainVO, CafeVO cafeVO, LikeVO likeVO, Model model, HttpSession session) {
		MemberVO loginInfo = (MemberVO)session.getAttribute("memberLoginInfo");
		
		String memCode = loginInfo == null ? "" : loginInfo.getMemCode();
		
		cafeVO.setMemCode(memCode);
		
		model.addAttribute("chainInfo", cafeService.selectChainInfo(cafeChainVO));
		
		//좌표간 거리구하기
//		List<CafeVO> cafeList = cafeService.selectCafeOfChainList(cafeVO);
//		double latitude1 = 35.5350070783584;
//		double longitude1 = 129.310830713355;
//		for(CafeVO e : cafeList) {
//			double latitude2 = Double.parseDouble(e.getCafeLatitude());
//			double longitude2 = Double.parseDouble(e.getCafeLongitude());
//			double distance = GeoDistance.geoDistance(latitude1, longitude1, latitude2, longitude2);
//			e.setDistance(distance);
//		}
		
	 	model.addAttribute("cafeOfChainList", cafeService.selectCafeOfChainList(cafeVO));
		return "cafe/select_chain";
	}
	
	
	//카페 주소정보
	@ResponseBody
	@PostMapping(value =  "/selectCafeMap", produces = "application/text; charset=UTF-8")
	public String selectMapInfo(CafeVO cafeVO) {
		String cafeAddr = cafeService.selectMapInfo(cafeVO);
		String result = "'" + cafeAddr + "'";
		return result;
	}
	
	//카페 상세정보, 메뉴정보
	@GetMapping("/cafeInfoAndMenu")
	public String cafeInfoAndMenu(CafeVO cafeVO, MenuVO menuVO, MenuOptionGroupVO menuOptionGroupVO, Model model) {
		model.addAttribute("cafeInfo", cafeService.selectCafeDetailInfo(cafeVO));
		model.addAttribute("cafeCategoryList", menuService.selectCafeCategoryList(cafeVO));
		model.addAttribute("cafeMenuList", menuService.selectMenuList(menuVO));
		model.addAttribute("optionGroupList", menuService.selectOptionGroupList(menuOptionGroupVO));
		model.addAttribute("menuOptionList", menuService.selectMenuOptionList(menuVO));
		return "cafe/cafe_info_and_menu";
	}
	
	//카페메뉴선택시 가져올 메뉴상세정보
	@ResponseBody
	@PostMapping("/selectMenuDetail")
	public MenuViewVO selectMenuDetail(MenuVO menuVO) {
		MenuViewVO result = menuService.selectMenuDetail(menuVO);
		return result;
	}
	
	//카페메뉴선택시 가져올 옵션그룹상세정보
	@ResponseBody
	@PostMapping("/selectMenuOptionDetail")
	public List<MenuOptionSelectedViewVO> selectMenuOptionDetail(MenuVO menuVO) {
		List<MenuOptionSelectedViewVO> result = menuService.selectMenuOptionDetail(menuVO);
		return result;
	}
	
	//카페메뉴선택시 가져올 옵션그룹별 옵션상세정보
	@ResponseBody
	@PostMapping("/selectMenuOptions")
	public List<MenuOptionViewVO> selectMenuOptions(MenuOptionGroupVO menuOptionGroupVO){
		List<MenuOptionViewVO> result = menuService.selectMenuOptions(menuOptionGroupVO);
		return result;
	}
	
	
	// 커뮤니티1_공지사항
	@GetMapping("/community1")
	public String community1(Model model) {
		List<BoardVO> noticeList1 = cafeService.noticeList1();
		List<BoardVO> noticeList2 = cafeService.noticeList2();
		// 하단 일반 공지사항 목록
		model.addAttribute("noticeList1", noticeList1);
		
		// 상단 중요 공지사항 목록
		model.addAttribute("noticeList2", noticeList2);
		return "cafe/board/community_side_notice";
	}
	
	// 커뮤니티2_이벤트
	@GetMapping("/community2")
	public String community2(Model model) {
		List<BoardVO> eventList = cafeService.eventList();
		model.addAttribute("eventList", eventList);
		return "cafe/board/community_side_event";
	}
	
	//커뮤니티3_이용자게시판
	@GetMapping("/community3")
	public String community3(Model model) {
		List<BoardVO> userBoardList = cafeService.userBoardList();
		model.addAttribute("userBoardList", userBoardList);
		return "cafe/board/community_side_userBoard";
	}
}
