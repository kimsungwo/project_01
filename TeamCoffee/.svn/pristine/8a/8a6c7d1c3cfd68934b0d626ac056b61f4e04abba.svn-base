package com.teamcoffee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TotalAuthInterceptor extends HandlerInterceptorAdapter{
	
	//로그인시 아이디/비밀번호 찾기, 회원가입 불가
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("memberLoginInfo") != null) {
			response.sendRedirect("/cafe/main");
			return false;
		}
		else if(session.getAttribute("ownerLoginInfo") != null) {
			response.sendRedirect("/cafe/main");
			return false;
		}

		return true;
	}
	
}
