package com.spring.service;

import java.util.List;

import com.spring.vo.ClassInfoVO;
import com.spring.vo.StudentVO;

public interface StudentService {
	//query실행을 위한 메소드 선언
	//학급 리스트 조회
	List<ClassInfoVO> selectClassList();
	//학생 리스트 조회 클래스적용
	List<StudentVO> selectStudentList(StudentVO studentVO);	
	//학생 개인정보조회
	StudentVO studentDetailList(StudentVO studentVO);
	//학생 개인정보 업데이트
	void updateScore(StudentVO studentVO);

}
