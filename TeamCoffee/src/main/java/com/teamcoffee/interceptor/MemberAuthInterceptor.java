package com.teamcoffee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.teamcoffee.member.vo.MemberVO;

public class MemberAuthInterceptor extends HandlerInterceptorAdapter{
	
	//로그아웃 시 권한 없는 페이지에서는 메인페이지로 이동
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO)session.getAttribute("memberLoginInfo");
		
		if(member == null) { 
			response.sendRedirect("/cafe/main");
			return false;
		}
		return true;
	}
	
}
