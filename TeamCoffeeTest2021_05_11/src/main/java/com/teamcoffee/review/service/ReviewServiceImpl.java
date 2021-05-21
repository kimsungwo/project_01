package com.teamcoffee.review.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamcoffee.review.vo.ReviewVO;
import com.teamcoffee.review.vo.ReviewViewVO;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void insertReview(ReviewVO reviewVO) {
		sqlSession.insert("insertReview", reviewVO);
		sqlSession.update("updateIsReviewed", reviewVO);
		sqlSession.update("updateCafeReviewCnt", reviewVO);
		sqlSession.update("updateCafeStar", reviewVO);
	}

	@Override
	public List<ReviewViewVO> reviewListbyMemCode(ReviewVO reviewVO) {
		return sqlSession.selectList("reviewListbyMemCode", reviewVO);
	}

	@Override
	public List<ReviewViewVO> reviewListbyCafeCode(ReviewVO reviewVO) {
		return sqlSession.selectList("reviewListbyCafeCode", reviewVO);
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void deleteReview(ReviewVO reviewVO) {
		sqlSession.delete("deleteReview", reviewVO);
		sqlSession.update("updateIsReviewedTurnToDefault", reviewVO);
		sqlSession.update("updateCafeReviewCnt", reviewVO);
		sqlSession.update("updateCafeStar", reviewVO);
	}

	@Override
	public List<ReviewViewVO> selectReviewDetail(ReviewVO reviewVO) {
		return sqlSession.selectList("selectReviewDetail", reviewVO);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public void updateReview(ReviewVO reviewVO) {
		sqlSession.update("updateReview", reviewVO);
		System.out.println("!!!!!!!!!!!!!1" + reviewVO.getCafeCode());
		sqlSession.update("updateCafeStar", reviewVO);
	}
}
