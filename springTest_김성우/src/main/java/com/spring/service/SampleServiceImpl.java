package com.spring.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vo.SampleVO;

@Service("sampleService") 
public class SampleServiceImpl implements SampleService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	//query실행을 위한 메소드 구현

	@Override
	public SampleVO loginForm(SampleVO sampleVO) {
		return sqlSession.selectOne("loginForm",sampleVO);
	}

	@Override
	public List<SampleVO> memberList() {
		return sqlSession.selectList("memberList");
	}
}
