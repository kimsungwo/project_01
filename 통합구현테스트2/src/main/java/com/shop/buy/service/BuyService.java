package com.shop.buy.service;

import java.util.List;

import com.shop.buy.vo.BuyVO;
import com.shop.buy.vo.BuyViewVO;
import com.shop.item.vo.ItemVO;
import com.shop.member.vo.MemberVO;

//회원정보 조회
public interface BuyService {

	MemberVO selectMember(String id);
	
	//상품 구매
	void insertBuy(BuyViewVO buyViewVO);
	
	//상품기록
	List<BuyViewVO> buyLog(BuyViewVO buyViewVO);
	
	


}
