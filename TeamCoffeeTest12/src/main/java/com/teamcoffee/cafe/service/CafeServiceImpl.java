package com.teamcoffee.cafe.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;

@Service("cafeService")
public class CafeServiceImpl implements CafeService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<CafeChainVO> selectChainList(CafeChainVO cafeChainVO) {
		return sqlSession.selectList("selectChainList", cafeChainVO);
	}

	@Override
	public List<CafeVO> selectCafeOfChainList(CafeVO cafeVO) {
		return sqlSession.selectList("selectCafeOfChainList", cafeVO);
	}
	
	@Override
	public CafeChainVO selectChainInfo(CafeChainVO cafeChainVO) {
		return sqlSession.selectOne("selectChainInfo", cafeChainVO);
	}
	
	@Override
	public String selectMapInfo(CafeVO cafeVO) {
		return sqlSession.selectOne("selectMapInfo", cafeVO);
	}
	
	@Override
	public CafeVO selectCafeDetailInfo(CafeVO cafeVO) {
		return sqlSession.selectOne("selectCafeDetailInfo", cafeVO);
	}
	
	@Override
	public List<BoardVO> noticeList1() {
		return sqlSession.selectList("noticeList1");
	}
	
	@Override
	public List<BoardVO> noticeList2() {
		return sqlSession.selectList("noticeList2");
	}


	@Override
	public List<BoardVO> eventList() {
		return sqlSession.selectList("eventList");
	}


	@Override
	public List<BoardVO> userBoardList() {
		return sqlSession.selectList("userBoardList");
	}

	
	
}