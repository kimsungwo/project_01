package com.teamcoffee.board.service;

import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.board.vo.BoardViewVO;
import com.teamcoffee.board.vo.ImgVO;

public interface BoardService {
	// 게시글 업로드
	public void boardUpload(BoardVO boardVO);
	
	// 게시글 상세보기
	public BoardViewVO boardDetail(BoardVO boardVO);
	
	// 게시글 수정
	public void updateBoard(BoardVO boardVO);
	
	// 게시글 삭제
	public void deleteBoard(BoardVO boardVO);
	
	// 게시물 이미지 업로드
	public void insertBoardImg(ImgVO imgVO);
	
	// 이미지 업로드 대상 게시물 번호 조회
	int selectMaxBoardNum();
	
	// 조회수 증가
	public int updateViewCnt(BoardVO boardVO);
	
	// 일반공지 게시글 총 개수 조회
	public int selectBoardCnt1(BoardVO boardVO);
	
	// 이벤트 게시글 총 개수 조회
	public int selectBoardCnt2(BoardVO boardVO);
	
	// 유저게시판 게시글 총 개수 조회
	public int selectBoardCnt3(BoardVO boardVO);
}