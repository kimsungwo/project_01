package com.spring.service;

import java.util.List;

import com.spring.vo.SampleVO;

public interface SampleService {
	//query실행을 위한 메소드 선언
	SampleVO loginForm(SampleVO sampleVO);
	
	//멤버리스트조회
	List<SampleVO> memberList();
	
}
