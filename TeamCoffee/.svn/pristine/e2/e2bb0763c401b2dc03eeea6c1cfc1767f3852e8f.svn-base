package com.teamcoffee.cafe.service;

import java.util.List;

import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.board.vo.ImgVO;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;

public interface CafeService {
	
	//체인점 리스트
	List<CafeChainVO> selectChainList(CafeChainVO cafeChainVO);
	
	//선택별 체인점 리스트
	List<CafeVO> selectCafeOfChainList(CafeVO cafeVO);
	
	//체인점 정보
	CafeChainVO selectChainInfo(CafeChainVO cafeChainVO);
	
	//카페 주소정보
	String selectMapInfo(CafeVO cafeVO);
	
	//선택한 카페정보
	CafeVO selectCafeDetailInfo(CafeVO cafeVO);
	
	// 일반공지 게시글 목록
	List<BoardVO> noticeList1(BoardVO boardVO);
	
	// 중요공지 게시글 목록
	List<BoardVO> noticeList2(BoardVO boardVO);
	
	// 이벤트 게시글 목록
	List<BoardVO> eventList();

	// 유저 게시글 목록;
	List<BoardVO> userBoardList(BoardVO boardVO);
}
