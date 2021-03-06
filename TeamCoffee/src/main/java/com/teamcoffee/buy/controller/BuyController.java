package com.teamcoffee.buy.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamcoffee.buy.service.BuyService;
import com.teamcoffee.buy.vo.BuyDetailVO;
import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.cart.service.CartService;
import com.teamcoffee.cart.vo.CartVO;
import com.teamcoffee.member.vo.MemberVO;

@Controller
@RequestMapping("/buy")
public class BuyController {
	@Resource(name = "buyService")
	private BuyService buyService;
	
	@Resource(name = "cartService")
	private CartService cartService;
	
	//바로 주문
	@GetMapping("/buyConfirm")
	public String buyConfirm(CartVO cartVO, Model model, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		cartVO.setMemCode(member.getMemCode());
		model.addAttribute("cartList", cartService.selectCartList(cartVO));
		model.addAttribute("memberInfo", buyService.selectBuyerInfo(member));
		model.addAttribute("cartSize", buyService.selectCartCodeSize(member));
		return "buy/buy_confirm";
	}
	
	//구매 테이블에 insert
	@ResponseBody
	@PostMapping("/insertBuyList")
	public int insertBuyList(BuyVO buyVO, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		buyVO.setMemCode(member.getMemCode());
		return buyService.insertBuyList(buyVO);
	}
	
	//구매리스트의 구매코드별 메뉴와 수량
	@ResponseBody
	@PostMapping("/selectBuyListMenu")
	public List<BuyViewVO> selectBuyListMenu(BuyVO buyVO){
		return buyService.selectBuyListMenu(buyVO);
	}
	
	//구매내역 상세정보
	@ResponseBody
	@PostMapping("/selectBuyDetail")
	public List<BuyViewVO> selectBuyDetail(BuyVO buyVO){
		return buyService.selectBuyDetail(buyVO);
	}
	
	//구매내역 상세정보 메뉴
	@ResponseBody
	@PostMapping("/selectBuyDetailMenu")
	public List<BuyViewVO> selectBuyDetailMenu(BuyVO buyVO){
		return buyService.selectBuyDetailMenu(buyVO);
	}
	
	//구매내역 상세정보 메뉴옵션
	@ResponseBody
	@PostMapping("/selectBuyDetailMenuOption")
	public List<BuyViewVO> selectBuyDetailMenuOption(BuyDetailVO buyDetailVO){
		return buyService.selectBuyDetailMenuOption(buyDetailVO);
	}
	
	//구매내역 포인트 사용 조회
	@ResponseBody
	@PostMapping("/selectBuyPoint")
	public int selectBuyPoint(BuyVO buyVO) {
		return buyService.selectBuyPoint(buyVO);
	}
	
	//구매상태 변경
	@ResponseBody
	@PostMapping("/updateBuyStatus")
	public int updateBuyStatus(BuyVO buyVO) {
		return buyService.updateBuyStatus(buyVO);
	}
	
	//포인트 환불
	@ResponseBody
	@PostMapping("/pointRefund")
	public int pointRefund(BuyVO buyVO, HttpSession session) {
		return buyService.pointRefund(buyVO);
	}
	
	//메시지 읽음
	@ResponseBody
	@PostMapping("/readMessage")
	public int readMessage(BuyVO buyVO) {
		return buyService.readMessage(buyVO);
	}

	//포인트 적립
	@ResponseBody
	@PostMapping("/pointSave")
	public int pointSave(BuyVO buyVO) {
		return buyService.pointSave(buyVO);
	}
	
}
