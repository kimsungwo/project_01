package com.teamcoffee.like.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.like.vo.LikeVO;

@Service("likeService")
public class LikeServiceImpl implements LikeService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public boolean isLikeChecked(LikeVO likeVO) {
		LikeVO vo = sqlSession.selectOne("selectLikeCode", likeVO);
		return vo == null ? false : true;  
	}

	@Override
	public void insertLikeVO(LikeVO likeVO) {
		sqlSession.insert("insertLikeVO", likeVO);
	}

	@Override
	public void deleteLikeVO(LikeVO likeVO) {
		sqlSession.delete("deleteLikeVO", likeVO);
	}

	@Override
	public List<LikeVO> likeCafeList(String memCode) {
		return sqlSession.selectList("likeCafeList", memCode);
	}

	@Override
	public int selectLikeCountToCafeCode(LikeVO likeVO) {
		return sqlSession.selectOne("selectLikeCountToCafeCode", likeVO);
	}
}
