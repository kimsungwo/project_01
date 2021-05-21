package com.teamcoffee.board.service;

import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.board.vo.ImgVO;

public interface BoardService {
	// 게시글 업로드
	public void boardUpload(BoardVO boardVO);
	
	// 게시글 상세보기
	public BoardVO boardDetail(int boardNum);
	
	// 게시글 수정
	public void updateBoard(BoardVO boardVO);
	
	// 게시글 삭제
	public void deleteBoard(int boardNum);
	
	// 게시물 이미지 업로드
	public void insertBoardImg(ImgVO imgVO);
	
	// 이미지 업로드 대상 게시물 번호 조회
	int selectMaxBoardNum();
	
	// 조회수 증가
	public int updateViewCnt(int boardNum);
}