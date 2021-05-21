package com.teamcoffee.buy.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.member.vo.MemberVO;

@Service("buyService")
public class BuyServiceImpl implements BuyService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVO selectBuyerInfo(MemberVO memberVO) {
		return sqlSession.selectOne("selectBuyerInfo", memberVO);
	}
	
}
