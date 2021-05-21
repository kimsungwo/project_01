package com.teamcoffee.board.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.board.vo.BoardVO;

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

}