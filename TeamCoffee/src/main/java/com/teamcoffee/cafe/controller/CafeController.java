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

import com.teamcoffee.board.service.BoardService;
import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.board.vo.PageVO;
import com.teamcoffee.cafe.service.CafeService;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.like.service.LikeService;
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
	
	@Resource(name = "boardService")
	private BoardService boardService;
	
	@Resource(name = "likeService")
	private LikeService likeService;
	
	//홈페이지 메인
	@GetMapping("/main")
	public String main(CafeChainVO cafeChainVO ,Model model) {
		model.addAttribute("chainList", cafeService.selectChainList(cafeChainVO));
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
		List<CafeVO> cafeList = cafeService.selectCafeOfChainList(cafeVO);
		double latitude1 = 35.5350070783584;
		double longitude1 = 129.310830713355;
		for(CafeVO e : cafeList) {
			if(e.getCafeLatitude() != null && e.getCafeLongitude() != null) {
				double latitude2 = Double.parseDouble(e.getCafeLatitude());
				double longitude2 = Double.parseDouble(e.getCafeLongitude());
				double distance = GeoDistance.geoDistance(latitude1, longitude1, latitude2, longitude2);
				String disStr = String.valueOf(Math.round(distance));
				if(disStr.length() > 3) {
					int disInt = Integer.parseInt(disStr);
					e.setDistance(String.valueOf(Math.round(disInt/1000)) + "km");
				}
				else { 
					e.setDistance(disStr + "m");
				}
			}
		}
		
		model.addAttribute("cafeOfChainList", cafeList);
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
	public String cafeInfoAndMenu(CafeVO cafeVO, MenuVO menuVO, MenuOptionGroupVO menuOptionGroupVO, Model model, LikeVO likeVO, HttpSession session) {
		boolean isClosed = cafeService.isClosedCafe(cafeVO);
		if(isClosed) {
			return "cafe/closed_cafe";
		}
		MemberVO loginInfo = (MemberVO)session.getAttribute("memberLoginInfo");
		String memCode = loginInfo == null ? "" : loginInfo.getMemCode();
		cafeVO.setMemCode(memCode);
		model.addAttribute("cafeInfo", cafeService.selectCafeDetailInfo(cafeVO));
		model.addAttribute("cafeCategoryList", menuService.selectCafeCategoryList(cafeVO));
		model.addAttribute("cafeMenuList", menuService.selectMenuList(menuVO));
		model.addAttribute("optionGroupList", menuService.selectOptionGroupList(menuOptionGroupVO));
		model.addAttribute("menuOptionList", menuService.selectMenuOptionList(menuVO));
		model.addAttribute("likeCnt",likeService.selectLikeCountToCafeCode(likeVO));
		return "cafe/cafe_info_and_menu";
	}
	
	//메뉴탭 변경시 카테고리에 따른 메뉴정보
	@ResponseBody
	@PostMapping("/selectCafeMenuCategory")
	public List<MenuViewVO> selectCafeMenuCategory(MenuVO menuVO) {
		List<MenuViewVO> result = menuService.selectMenuList(menuVO);
		return result;
	}
	
	//메뉴찾기
	@ResponseBody
	@PostMapping("/searchMenu")
	public List<MenuViewVO> searchMenu(MenuVO menuVO) {
		List<MenuViewVO> result = menuService.selectMenuList(menuVO);
		return result;
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
	public String community1(Model model, BoardVO boardVO, PageVO pageVO) {
		// 일반공지 게시글 총 수
		int totalCnt = boardService.selectBoardCnt1(boardVO);
		pageVO.setTotalCnt(totalCnt);
		pageVO.createPage();
		model.addAttribute("pageInfo", pageVO);
		
		boardVO.setStartNum(pageVO.getStartNum());
		boardVO.setEndNum(pageVO.getEndNum());
		model.addAttribute("totalCnt", totalCnt);
		
		List<BoardVO> noticeList1 = cafeService.noticeList1(boardVO);
		List<BoardVO> noticeList2 = cafeService.noticeList2(boardVO);
		
		// 하단 일반 공지사항 목록
		model.addAttribute("noticeList1", noticeList1);
		
		// 상단 중요 공지사항 목록
		model.addAttribute("noticeList2", noticeList2);
		return "cafe/board/community_side_notice";
	}
	
	// 커뮤니티2_이벤트
	@GetMapping("/community2")
	public String community2(Model model, BoardVO boardVO, PageVO pageVO) {
		// 게시글의 총 수
		int totalCnt = boardService.selectBoardCnt2(boardVO);
		pageVO.setTotalCnt(totalCnt);
		pageVO.createPage();
		model.addAttribute("pageInfo", pageVO);
		
		boardVO.setStartNum(pageVO.getStartNum());
		boardVO.setEndNum(pageVO.getEndNum());
		model.addAttribute("totalCnt", totalCnt);
		
		List<BoardVO> eventList = cafeService.eventList();
		model.addAttribute("eventList", eventList);
		
		return "cafe/board/community_side_event";
	}
	
	//커뮤니티3_이용자게시판
	@GetMapping("/community3")
	public String community3(Model model, BoardVO boardVO, PageVO pageVO) {
		// 페이징 처리
		//PageVO pageInfo = new PageVO(); // nowPage = 1;
		
		// 현재 클릭한 페이지 번호를 받아 옴
		
		
		// 게시글의 총 수
		int totalCnt = boardService.selectBoardCnt3(boardVO);
		pageVO.setTotalCnt(totalCnt);
		pageVO.createPage();
		model.addAttribute("pageInfo", pageVO);
		
		boardVO.setStartNum(pageVO.getStartNum());
		boardVO.setEndNum(pageVO.getEndNum());
		model.addAttribute("totalCnt", totalCnt);
		
		
		List<BoardVO> userBoardList = cafeService.userBoardList(boardVO);
		model.addAttribute("userBoardList", userBoardList);
		
		return "cafe/board/community_side_userBoard";
	}
}