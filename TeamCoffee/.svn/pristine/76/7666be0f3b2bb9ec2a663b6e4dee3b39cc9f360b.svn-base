package com.teamcoffee.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.teamcoffee.owner.service.OwnerService;
import com.teamcoffee.owner.vo.OwnerVO;

public class OwnerRememberInterceptor extends HandlerInterceptorAdapter {
	
	@Inject
	private OwnerService ownerService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Cookie ownerLoginCookie = WebUtils.getCookie(request, "ownerLoginCookie");
		if(ownerLoginCookie != null) {
			OwnerVO ownerVO = ownerService.ownerCheckLoginBefore(ownerLoginCookie.getValue());
			if(ownerVO != null)
				session.setAttribute("ownerLoginInfo", ownerVO);
		}
		return true;
	}
	
}
