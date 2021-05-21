package com.teamcoffee.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.teamcoffee.member.service.MemberService;
import com.teamcoffee.member.vo.MemberVO;

public class MemberRememberInterceptor extends HandlerInterceptorAdapter {
	
	@Inject
	private MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			MemberVO memberVO = memberService.checkLoginBefore(loginCookie.getValue());
			if(memberVO != null)
				session.setAttribute("memberLoginInfo", memberVO);
		}
		return true;
	}
	
}