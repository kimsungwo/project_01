package com.shop.item.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shop.buy.service.BuyService;
import com.shop.buy.vo.BuyVO;
import com.shop.buy.vo.BuyViewVO;
import com.shop.item.service.ItemService;
import com.shop.item.vo.ItemViewVO;
import com.shop.member.service.MemberService;
import com.shop.member.vo.MemberVO;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Resource(name="itemService")
	private ItemService itemService;
	
	@Resource(name="memberService") //얘가 받는거임
	private MemberService memberService;
	
	@Resource(name="buyService") //얘가 받는거임 
	private BuyService buyService;//buyService객체를 시작하면 적용시켜줄것선언
	
	
	@GetMapping("/itemList")
	public String itemList(Model model) {
		//상품 카테고리 목록을 조회후 와야됨
		model.addAttribute("categoryList",itemService.selectCategoryList());
		model.addAttribute("itemList", itemService.selectItemList());
		return "item/item_list";
	}
	
	@GetMapping("/itemDetail")
	public String itemDetail(Model model,ItemViewVO itemViewVO,MemberVO memberVO) {
		
		model.addAttribute("detailList", itemService.selectItemDetail(itemViewVO));
		model.addAttribute("categoryList",itemService.selectCategoryList());
		//model.addAttribute("itemList", itemService.selectItemList());
		return "item/item_detail";
	}
	//구매정보 확인페이지
		@PostMapping("/buyInfo")
		public String buyInfo(BuyViewVO buyViewVO,MemberVO memberVO,HttpSession session,Model model) {
			int totalPrice = buyViewVO.getItemPrice()*buyViewVO.getBuyQuantity();
			buyViewVO.setTotalPrice(totalPrice);
			//매개변수에 선언된 커맨드객체는 따로 model로 넘기지 않아도 알아서 넘어감
			MemberVO member = (MemberVO)session.getAttribute("loginInfo");
			//buyService.selectMember(member.getId());
			model.addAttribute("memberInfo",buyService.selectMember(member.getId()));
			model.addAttribute("categoryList",itemService.selectCategoryList());
			return "item/buy_info";
		}

}











