package com.teamcoffee.owner.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.owner.vo.OwnerVO;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertOwner(OwnerVO ownerVO) {
		sqlSession.insert("insertOwner", ownerVO);
	}

	@Override
	public OwnerVO ownerLoginProcess(OwnerVO ownerVO) {
		return sqlSession.selectOne("ownerLoginProcess", ownerVO);
	}

	@Override
	public OwnerVO selectOwnerInfo(OwnerVO ownerVO) {
		return sqlSession.selectOne("selectOwnerInfo", ownerVO);
	}

	@Override
	public void insertCafe(CafeVO cafeVO) {
		sqlSession.insert("insertCafe", cafeVO);
		
	}

	@Override
	public String selectChainLogo(CafeChainVO cafeChainVO) {
		return sqlSession.selectOne("selectChainLogo", cafeChainVO);
	}

	@Override
	public List<CafeVO> CafeInfoList(OwnerVO ownerVO) {
		return sqlSession.selectList("CafeInfoList", ownerVO);
	}

	@Override
	public CafeVO selectCafeInfo(CafeVO cafeVO) {
		return sqlSession.selectOne("selectCafeInfo", cafeVO);
	}

	@Override
	public void cafeInfoUpdate(CafeVO cafeVO) {
		sqlSession.update("cafeInfoUpdate", cafeVO);
	}

	@Override
	public void deleteCafe(CafeVO cafeVO) {
		sqlSession.delete("deleteCafe", cafeVO);
	}
	
}
