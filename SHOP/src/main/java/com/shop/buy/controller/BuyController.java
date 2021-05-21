package com.shop.buy.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.buy.service.BuyService;
import com.shop.buy.vo.BuyVO;
import com.shop.buy.vo.BuyViewVO;
import com.shop.item.vo.ItemVO;
import com.shop.member.service.MemberService;
import com.shop.member.vo.MemberVO;


@Controller
@RequestMapping("/buy")
public class BuyController {

	@Resource(name="memberService") //얘가 받는거임
	private MemberService memberService;

	@Resource(name="buyService") //얘가 받는거임
	private BuyService buyService;
	
	//구매완료페이지
	
	@PostMapping("/insertBuy")
	public String insertBuy(BuyViewVO buyViewVO,HttpSession session) {
		MemberVO member = (MemberVO)session.getAttribute("loginInfo");
		buyViewVO.setBuyer(member.getId());
		buyService.insertBuy(buyViewVO);
		
		
		return "redirect:/item/itemList";
	}
	
}
