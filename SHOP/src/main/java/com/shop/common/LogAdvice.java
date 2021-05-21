package com.shop.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

//AOP관련용어
//조인포인트(joinpoint)
//- 공통로직이 실행되는 후보메소드

//포인트컷(pointcut)
//조인포인트 중에서 실제 aop가 적용되는 대상이 되는 메소드 

//어드바이스(advice)
//-포인트컷에서 실행되는 공통 작업

//에스팩트(aspect)
//포인트컷 + 어드바이스. 실행되는 전체


//어드바이스 실행 시점
//before - 포인트컷이 실행되기 전
//after - 포인트컷이 실행된 후
//1)after returning 포인트컷이 정상적으로 실행된후 
//2)after throwing 포인트컷이 실행 중 오류가 발생한 이후
//3)after 포인트컷이 실행 성공 여부와 연관없이 무조건
//around - 포인트컷이 실행되기 전후 모두 실행

//포인트컷 표현식 
//메소드 리턴 표현식
// 1) * : 모든 리턴타입을 허용
// 2) void : 리턴타입이  void형인 메소드만 적용
// 3) !void : 리턴타입이 void형은 제외

//2. 패키지경로 표현식 
// 1)com.spring.biz. : 정확히 해당 패키지만 선택
// 2)com.spring.biz..: 정확히 해당 패키지 하위의 모든패키지 선택
// 3)com.spring.biz..Impl.: 정확히 해당 패키지 하위의 모든패키지중 패키지명이 Impl인것만 선택
// 3)com.spring.biz..Impl.*Impl: 정확히 해당 패키지 하위의 모든패키지중 패키지명이 Impl인 패키지중 Impl로 끝나는 모든 메소드를 선택
//3. 클래스명 표현식
// 1) BoardServiceImpl : 해당 클래스만 선택
// 2) *Impl : Impl로 끝나는 모든클래스
// 3) BoardService+ : 해당 클래스로부터 파생된 클래스 (자식클래스,인터페이스를 구현한 클래스)
//4. 메소드의 매개변수 표현식
// 1) (..) : 매개변수의 타입이나 개수에 무관
// 2) (*) : 매개변수가 반드시 하나인것만 적용  두개면 (*,*)
// 3) (com.spring.board.vo.BoardVO) : 매개변수의 자료형이 BoardVO인것만 패키지명까지 반드시 작성
//우리가 만든 자료형만 적어줘야됨

//ex) 매개변수가 반드시 두개인데 첫번째 매개변수는 문자열, 두번째매개변수는 무관
//(String,*)               (String,..)..은 타입이나 갯수 무관

public class LogAdvice {
	public void before(JoinPoint pj) {
		//System.out.println("[공통] - 작업");
		String method = pj.getSignature().toLongString();//메소드의 리턴타입,매개변수정보포함해서 가져옴

//		String method = pj.getSignature().getName();
		Object[] args = pj.getArgs();
		String param = "";
		
		if(args != null && args.length != 0) {
			param = args[0].toString();
		}

		
		System.out.println("[사전 작업] - " +method+ "()시작");
		System.out.println("파라메터 정보 : " +param);
		//System.out.println("[사전 작업] - " +method+ "() / 파라메터 정보 : " + args[0].toString());
	}
	public void after(JoinPoint jp) {
		
		String method= jp.getSignature().getName();
		System.out.println("[사후 작업]"+method+"() 실행 종료");
		
		//System.out.println();
		//System.out.println("[common] - 사후작업");
	//	System.out.println();
	}
	
	public void afterReturn(Object returnObj) {
		System.out.println("deleteBoard()메소드 실행 후 동작");
		System.out.println("리턴 정보 : "+ returnObj.toString());
	}
	
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {//프로그램이 실행전후 둘다호출
		String method = pjp.getSignature().getName();
		StopWatch time = new StopWatch();
		
		System.out.println(method+"시작!");
		
		time.start();
		Object obj =  pjp.proceed();
		time.stop();
		
		System.out.println(method+"끗!");
		System.out.println("메소드 작업시간 : " + time.getTotalTimeMillis()+"초");
		
		return obj;
		
	}
}

class Log4jAdvice{
	public void newBefore() {
		System.out.println("NEW [공통] - 작업");
	}
	public void newBefore1() {
		System.out.println("NEW [공통] - 작업1");
	}
}
