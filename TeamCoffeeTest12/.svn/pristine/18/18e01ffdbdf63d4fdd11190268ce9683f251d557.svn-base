package com.teamcoffee.cafe.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.cafe.vo.CafeChainVO;

@Service("cafeService")
public class CafeServiceImpl implements CafeService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<CafeChainVO> selectChainList() {
		return sqlSession.selectList("selectChainList");
	}


	@Override
	public List<BoardVO> noticeList() {
		return sqlSession.selectList("noticeList");
	}
	
}
