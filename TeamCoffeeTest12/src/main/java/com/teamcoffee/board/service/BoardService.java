package com.teamcoffee.board.service;

import com.teamcoffee.board.vo.BoardVO;

public interface BoardService {
	// 게시글 업로드
	public void boardUpload(BoardVO boardVO);
	
	// 게시글 상세보기
	public BoardVO boardDetail(int boardNum);
	
	// 게시글 수정
	public void updateBoard(BoardVO boardVO);
	
	// 게시글 삭제
	public void deleteBoard(int boardNum);
}