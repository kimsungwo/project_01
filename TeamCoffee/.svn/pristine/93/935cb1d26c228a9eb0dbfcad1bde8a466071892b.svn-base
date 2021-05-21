package com.teamcoffee.board.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.board.vo.BoardViewVO;
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
	public BoardViewVO boardDetail(BoardVO boardVO) {
		return sqlSession.selectOne("boardDetail", boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		sqlSession.update("updateBoard", boardVO);
	}

	@Override
	public void deleteBoard(BoardVO boardVO) {
		sqlSession.delete("delete", boardVO);
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
	public int updateViewCnt(BoardVO boardVO) {
		return sqlSession.update("viewCnt", boardVO);
	}
	
	@Override
	public int selectBoardCnt1(BoardVO boardVO) {
		return sqlSession.selectOne("selectBoardCnt1", boardVO);
	}
	
	@Override
	public int selectBoardCnt2(BoardVO boardVO) {
		return sqlSession.selectOne("selectBoardCnt2", boardVO);
	}

	@Override
	public int selectBoardCnt3(BoardVO boardVO) {
		return sqlSession.selectOne("selectBoardCnt3", boardVO);
	}
}