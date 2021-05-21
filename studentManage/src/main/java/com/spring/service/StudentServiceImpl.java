package com.spring.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vo.ClassInfoVO;
import com.spring.vo.StudentVO;

@Service("studentService") 
public class StudentServiceImpl implements StudentService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	//query실행을 위한 메소드 구현

	@Override
	//학급리스트 조회
	public List<ClassInfoVO> selectClassList() {
		return sqlSession.selectList("selectClassList");
	}

	@Override
	//학생 리스트 조회
	public List<StudentVO> selectStudentList(StudentVO studentVO) {
		return	sqlSession.selectList("selectStudentList",studentVO);
	}

	@Override
	//학생 개인정보조회
	public StudentVO studentDetailList(StudentVO studentVO) {
		return sqlSession.selectOne("studentDetailList", studentVO);
	}

	@Override
	public void updateScore(StudentVO studentVO) {
		sqlSession.update("updateScore", studentVO);
	}


}
