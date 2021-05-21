package com.teamcoffee.review.service;

import java.util.List;

import com.teamcoffee.review.vo.ReviewVO;
import com.teamcoffee.review.vo.ReviewViewVO;

public interface ReviewService  {
	//리뷰등록
	void insertReview(ReviewVO reviewVO);
	//멤버별 리뷰목록
	List<ReviewViewVO> reviewListbyMemCode(ReviewVO reviewVO);
	//카페별 리뷰목록
	List<ReviewViewVO> reviewListbyCafeCode(ReviewVO reviewVO);
	//리뷰삭제
	void deleteReview(ReviewVO reviewVO);
	//리뷰상세정보
	List<ReviewViewVO> selectReviewDetail(ReviewVO reviewVO);
	//리뷰수정
	void updateReview(ReviewVO reviewVO);
}
