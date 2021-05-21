package com.spring.biz;

import java.util.List;

import com.spring.vo.BoardVO;

public interface BoardService {
	//게시글 목록조회
	List<BoardVO> selectBoardList();
	//게시글 상세조회
	BoardVO selectBoard(int boardNum);
	
	//게시글 추가
	void insertBoard(BoardVO boardVO);
}

