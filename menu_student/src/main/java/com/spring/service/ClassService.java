package com.spring.service;

import java.util.List;

import com.spring.vo.ClassVO;

public interface ClassService {
	//query실행을 위한 메소드 선언
	List<ClassVO> selectClassList();
	
	//학급정보등록
	void insertClass(ClassVO classVO);
	
	//학급정보삭제
	void deleteClass(ClassVO classVO);



}
