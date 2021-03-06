package com.teamcoffee.buy.service;

import java.util.List;

import com.teamcoffee.buy.vo.BuyDetailVO;
import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.member.vo.MemberVO;

public interface BuyService {
	
	//장바구니 메뉴 개수
	int selectCartCodeSize(MemberVO memberVO);
	
	//구매자의 정보
	MemberVO selectBuyerInfo(MemberVO memberVO);
	
	//구매 테이블에 insert
	int insertBuyList(BuyVO buyVO);
	
	//구매내역 리스트
	List<BuyViewVO> selectBuyList(MemberVO memberVO);
	
	//구매내역 리스트별 메뉴, 수량
	List<BuyViewVO> selectBuyListMenu(BuyVO buyVO);
	
	//구매내역 상세정보
	List<BuyViewVO> selectBuyDetail(BuyVO buyVO);
	
	//구매내역 메뉴정보
	List<BuyViewVO> selectBuyDetailMenu(BuyVO buyVO);
	
	//구매내역 메뉴옵션정보
	List<BuyViewVO> selectBuyDetailMenuOption(BuyDetailVO buyDetailVO);
	
	//구매내역에 사용포인트 가져오기
	int selectBuyPoint(BuyVO buyVO);
	
	//리뷰폼을 위한 구매상세내역
	List<BuyViewVO> selectBuyDetailForReviewForm(BuyVO buyVO);
	
	//구매상태 변경
	int updateBuyStatus(BuyVO buyVO);
	
	//포인트 환불
	int pointRefund(BuyVO buyVO);
	
	//메시지 읽음
	int readMessage(BuyVO buyVO);
	
	//포인트 적립
	int pointSave(BuyVO buyVO);
	
}
