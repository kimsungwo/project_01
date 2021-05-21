package com.teamcoffee.board.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.board.vo.ImgVO;

@Service("boardService")
public class BoardServiceImpl implements BoardService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void boardUpload(BoardVO boardVO) {
		sqlSession.insert("boardUpload", boardVO);
	}

	@Override
	public BoardVO boardDetail(int boardNum) {
		return sqlSession.selectOne("boardDetail", boardNum);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		sqlSession.update("updateBoard", boardVO);
	}
	
	@Override
	public void deleteBoard(int boardNum) {
		sqlSession.delete("delete", boardNum);
	}

	@Override
	public void insertBoardImg(ImgVO imgVO) {
		sqlSession.insert("insertBoardImgs", imgVO);
	}

	@Override
	public int selectMaxBoardNum() {
		return sqlSession.selectOne("selectMaxBoardNum");
	}

	@Override
	public int updateViewCnt(int boardNum) {
		return sqlSession.update("viewCnt", boardNum);
	}
}