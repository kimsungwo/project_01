package com.teamcoffee.cart.controller;

import java.util.Optional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teamcoffee.cart.service.CartService;
import com.teamcoffee.cart.vo.CartOptionVO;
import com.teamcoffee.cart.vo.CartVO;
import com.teamcoffee.member.service.MemberService;
import com.teamcoffee.member.vo.MemberVO;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Resource(name = "cartService")
	private CartService cartService;
	
	@Resource(name = "memberService")
	private MemberService memberService;
	
	//장바구니 메뉴의 cafeCode 체크
	@ResponseBody
	@PostMapping("/isOverlabCart")
	public boolean isOverlabCart(CartVO cartVO, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		cartVO.setMemCode(member.getMemCode());
		return cartService.isOverlabCart(cartVO);
	}
	
	//장바구니 넣기
	@ResponseBody
	@PostMapping("/insertCart")
	public int insertCart(CartVO cartVO, CartOptionVO cartOptionVO, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		cartVO.setMemCode(member.getMemCode());
		return cartService.insertCart(cartVO, cartOptionVO);
	}
	
	//장바구니 이동
	@GetMapping("/cartList")
	public String cartList(CartVO cartVO, Model model, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		cartVO.setMemCode(member.getMemCode());
		model.addAttribute("cartList", cartService.selectCartList(cartVO));
		model.addAttribute("memberInfo", memberService.memberInfo(member));
		return "cart/cart_list";
	}
	
	//수량 변경
	@ResponseBody
	@PostMapping("/updateBuyQuantity")
	public int updateBuyQuantity(CartVO cartVO) {
		return cartService.updateBuyQuantity(cartVO);
	}
	
	//장바구니 삭제
	@ResponseBody
	@PostMapping("/deleteCart")
	public int deleteCart(CartVO cartVO, HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		cartVO.setMemCode(member.getMemCode());
		
		Optional<CartVO> c = Optional.ofNullable(cartVO);
		String cartCode = c.map(s -> s.getCartCode()).orElse("");
		cartVO.setCartCode(cartCode);
		return cartService.deleteCart(cartVO);
	}
	
	
	
	
}
