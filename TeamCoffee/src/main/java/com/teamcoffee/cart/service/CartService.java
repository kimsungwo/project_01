package com.teamcoffee.cart.service;

import java.util.List;

import com.teamcoffee.cart.vo.CartOptionVO;
import com.teamcoffee.cart.vo.CartVO;
import com.teamcoffee.cart.vo.CartViewVO;

public interface CartService {
	
	//장바구니 추가
	int insertCart(CartVO cartVO, CartOptionVO cartOptionVO);
	
	//장바구니 리스트
	List<CartViewVO> selectCartList(CartVO cartVO);
	
	//수량 변경
	int updateBuyQuantity(CartVO cartVO);
	
	//장바구니 삭제
	int deleteCart(CartVO cartVO);
	
	//장바구니 체크
	boolean isOverlabCart(CartVO cartVO);
	
}
