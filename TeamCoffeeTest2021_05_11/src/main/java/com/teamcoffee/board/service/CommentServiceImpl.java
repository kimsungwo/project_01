package com.teamcoffee.board.service;


import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.board.vo.CommentVO;
import com.teamcoffee.board.vo.ImgVO;

@Service("commentService")
public class CommentServiceImpl implements CommentService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void commentUpload(CommentVO commentVO) {
		sqlSession.insert("insertComment", commentVO);
	}

	@Override
	public List<CommentVO> selectComments(int boardNum) {
		return sqlSession.selectList("selectComments", boardNum);
	}

	@Override
	public void deleteComment(String commentCode) {
		sqlSession.delete("deleteComment", commentCode);
	}
}