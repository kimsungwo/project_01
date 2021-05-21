package com.spring.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vo.ClassVO;
import com.spring.vo.StudentVO;

@Service("studentService") 
public class StudentServiceImpl implements StudentService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	//query실행을 위한 메소드 구현

	@Override
	//학급리스트 조회
	public List<ClassVO> selectClassList() {
		return sqlSession.selectList("selectClassList");
	}

	@Override
	//학생 리스트 조회
	public List<StudentVO> selectStudentList(StudentVO studentVO) {
		return	sqlSession.selectList("selectStudentList",studentVO);
	}


}
