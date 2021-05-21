package com.shop.aop.service;

import org.springframework.stereotype.Service;

import com.shop.common.LogAdvice;

@Service("aopService")
public class AopServiceImpl implements AopService {

	LogAdvice advice = new LogAdvice();
	//Log4jAdvice advices = new Log4jAdvice();
	
	@Override
	public void insertBoard(String str) {
		
		//advice.before();
	//	advice.newBefore();
		System.out.println("게시글 등록");
	}

	@Override
	public void updateBoard(int num) {
		//advice.before();
		//advice.newBefore();
		System.out.println("게시글 수정");
	}

	@Override
	public void selectBoard() {
		//advice.before();
		//advice.newBefore();
		System.out.println("게시글 조회");
	}

	@Override
	public int deleteBoard() {
		System.out.println("게시글 삭제");
		return 1;//삭제되면 1리턴
	}
	

}
