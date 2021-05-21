package com.shop.common;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//객체생성 컴포넌트
@Aspect//이게 들어가야 작업함.
public class AnnoAdvice {

	
	@Before("ShopPointCut.allPointcut()")//해당작업즉 메소드명이 실행되기전에 실행하겠다.
	public void before() {
		System.out.println("[공통 작업] - 사전 작업");
	}
	
	
	@AfterReturning(pointcut="ShopPointCut.returnPointcut()",returning = "returnObj") 
	//주소는 같은패키지내에 있다면 해당클래스명.실행할메소드명
	public void showReturnValue(Object returnObj) {//그 리턴값을 출력할거임
		System.out.println("메소드 실행 후 리턴 값 : " + returnObj.toString());
	}
	
	
	
}
