package com.teamcoffee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.teamcoffee.owner.vo.OwnerVO;

public class OwnerAuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		OwnerVO owner = (OwnerVO)session.getAttribute("ownerLoginInfo");
		
		if(owner == null) { 
			response.sendRedirect("/cafe/main");
			return false;
		}
		return true;
	}

	
	
}
