package com.shop.buy.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.buy.vo.BuyVO;
import com.shop.buy.vo.BuyViewVO;
import com.shop.item.vo.ItemVO;
import com.shop.member.vo.MemberVO;

@Service("buyService")
public class BuyServiceImpl implements BuyService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	
	
	@Override
	public MemberVO selectMember(String id) {
		return sqlSession.selectOne("selectMember", id);
	}



	@Override
	//@Transactional(rollbackFor = Exception.class)
	public void insertBuy(BuyViewVO buyViewVO) {
		sqlSession.update("insertBuy",buyViewVO);
		//sqlSession.update("updateItemStock",buyViewVO);
	}



	@Override
	public List<BuyViewVO> buyLog(BuyViewVO buyViewVO) {
		return sqlSession.selectList("buyLog",buyViewVO);
		
	}





	






}
