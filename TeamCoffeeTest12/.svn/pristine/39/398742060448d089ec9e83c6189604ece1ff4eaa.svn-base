package com.teamcoffee.buy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teamcoffee.buy.service.BuyService;
import com.teamcoffee.cafe.service.CafeService;
import com.teamcoffee.cart.service.CartService;
import com.teamcoffee.cart.vo.CartVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.menu.service.MenuService;

@Controller
@RequestMapping("/buy")
public class BuyController {
	@Resource(name = "buyService")
	private BuyService buyService;
	
	@Resource(name = "menuService")
	private MenuService menuService;
	
	@Resource(name = "cafeService")
	private CafeService cafeService;
	
	@Resource(name = "cartService")
	private CartService cartService;
	
	//바로 주문
	@GetMapping("/buyConfirm")
	public String buyConfirm(CartVO cartVO, Model model, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		cartVO.setMemCode(member.getMemCode());
		model.addAttribute("cartList", cartService.selectCartList(cartVO));
		model.addAttribute("memberInfo", buyService.selectBuyerInfo(member));
		return "buy/buy_confirm";
	}
	
	
}
