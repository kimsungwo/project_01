package com.shop.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ShopPointCut {
	@Pointcut("execution(* com.shop.aop..*Impl.*(..))")
	public void allPointcut() {}//구현부 필요없음. 위의 위치설정이 필요한것뿐
	
	@Pointcut("execution(!void com.shop.aop..*Impl.*(..))") 
	public void returnPointcut() {}
	
}
