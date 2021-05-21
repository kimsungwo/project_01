package com.spring.service;

import java.util.List;

import com.spring.vo.SampleVO;
import com.spring.vo.SampleVO2;

public interface SampleService {
	//query실행을 위한 메소드 선언
	
	//부서삽입
	void insertDept(SampleVO sampleVO);
	//부서리스트조회
	List<SampleVO> selectDeptList();
	//부서리스트조회
	List<SampleVO> selectDeptNameList();
	//인구삽입
	void insertEmp(SampleVO2 sampleVO2);
	//삽입된 인구조회
	List<SampleVO2> selectEmpList();
	
	
}
