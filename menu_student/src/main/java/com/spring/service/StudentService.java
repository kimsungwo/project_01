package com.spring.service;

import java.util.List;

import com.spring.vo.ClassVO;
import com.spring.vo.StudentVO;

public interface StudentService {
	//query실행을 위한 메소드 선언
	//학급 리스트 조회
	List<ClassVO> selectClassList();
	//학생 리스트 조회 클래스적용
	List<StudentVO> selectStudentList(StudentVO studentVO);	


}
