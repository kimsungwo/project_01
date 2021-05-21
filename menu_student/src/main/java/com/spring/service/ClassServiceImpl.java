package com.spring.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vo.ClassVO;

@Service("classService") 
public class ClassServiceImpl implements ClassService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	//query실행을 위한 메소드 구현

	@Override
	public List<ClassVO> selectClassList() {
		return sqlSession.selectList("selectClassList");
	}

	@Override
	public void insertClass(ClassVO classVO) {
		sqlSession.insert("insertClass",classVO);
	}

	@Override
	public void deleteClass(ClassVO classVO) {
		sqlSession.delete("deleteClass",classVO);
	}
}
