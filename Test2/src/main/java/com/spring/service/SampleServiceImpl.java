package com.spring.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vo.SampleVO;
import com.spring.vo.SampleVO2;

@Service("sampleService") 
public class SampleServiceImpl implements SampleService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	//query실행을 위한 메소드 구현

	//부서삽입
	@Override
	public void insertDept(SampleVO sampleVO) {
		sqlSession.insert("insertDept", sampleVO);
	}
	//부서리스트조회
	@Override
	public List<SampleVO> selectDeptList() {
		return sqlSession.selectList("selectDeptList"); 
	}
	@Override
	public List<SampleVO> selectDeptNameList() {
		return sqlSession.selectList("selectDeptNameList"); 
	}
	@Override
	public void insertEmp(SampleVO2 sampleVO2) {
		sqlSession.insert("insertEmp",sampleVO2);
	}
	@Override
	public List<SampleVO2> selectEmpList() {
		return sqlSession.selectList("selectEmpList"); 
	}
}
