package com.spring.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sampleService") 
public class SampleServiceImpl implements SampleService {
	@Autowired
	private SqlSessionTemplate sqlSession;
	//query실행을 위한 메소드 구현
}
