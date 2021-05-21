package com.shop.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shop.item.service.ItemService;
//HandlerInterceptorAdapter 클래스를 상속하여 만든 클래스는 인터셉터의 기능을 정의할 수 있다.
public class MenuInterceptor extends HandlerInterceptorAdapter {
	//컨트롤러로 진입하기전 실행되는 메소드
	@Resource(name="itemService") 
	private ItemService itemService;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("---------------------------preHandle실행-------------------------------");
		
		
		return true;
		//리턴은 boolean자료형에 따라 true,false로 준다.
		//true->인터셉터 실행후 원래요청경로로 이동
		//false->인터셉터 실행후 원래요청경로로 이동하지않음.
		//return super.preHandle(request, response, handler);
	}
	
	
	//컨트롤러의 메소드가 실행된후 jsp로 가기전에 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("---------------------------postHandle실행-------------------------------");
		
		modelAndView.addObject("categoryList",itemService.selectCategoryList());
		//super.postHandle(request, response, handler, modelAndView);
	}
	//HandlerInterceptorAdapter에 정의된 메소드를 오버라이딩하여 필요한 기능을 구현
	
}
