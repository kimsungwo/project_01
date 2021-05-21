package com.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shop.member.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	//컨트롤러로 이동전에 login유무체크후 페이지이동 컨트롤
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();//세션에대한 객체생성
		MemberVO loginInfo = (MemberVO)session.getAttribute("loginInfo");
		if(loginInfo == null) {
			response.sendRedirect("/item/itemList"); //페이지이동
			return false ;
		}
		return true;
	//	return super.preHandle(request, response, handler);
	}
	
}
//1.상품구매후 구매갯수만큼 상품재고차감
//  -트렌젝션처리 반드시 할것
//  -만약 재고가 부족하다면 구매버튼클릭시 '재고없음ㅅㄱ'alert띄우기


//2. 상품목록조회시 카테고리별 목록이 조회되게 변경