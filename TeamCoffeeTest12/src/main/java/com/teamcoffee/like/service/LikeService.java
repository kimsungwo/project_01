package com.teamcoffee.like.service;

import java.util.List;

import com.teamcoffee.like.vo.LikeVO;

public interface LikeService {
	
	//좋아요 체크여부
	boolean isLikeChecked(LikeVO likeVO);
	
	//체크 no
	void insertLikeVO(LikeVO likeVO);
	
	//체크 yes
	void deleteLikeVO(LikeVO likeVO);
	
	//찜한 매장리스트
	List<LikeVO> likeCafeList(String memCode);
	
}
