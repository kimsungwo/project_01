package com.spring.biz;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vo.BoardVO;

//@Component /* 스프링에서 쓰는 어노테이션. 자동완성됨. 실행될때 자동으로 클래스생성해줌.얘도 상속을 하고있다. */
//단 ,자동객체생성위해선  servlet-context.xml(컨트롤러설정파일)에 component-scan태그가 있어야됨

			
@Service("boardService") //@Component 이거랑 같음. 객체 생성때" "안으로 객체명을 만들어줌
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<BoardVO> selectBoardList() {
		//List<BoardVO> list = sqlSession.selectList("selectBoardList");
		//return list;
		return sqlSession.selectList("selectBoardList");
	}

	@Override
	public BoardVO selectBoard(int boardNum) {
		return sqlSession.selectOne("selectBoard",boardNum);
	}

	@Override
	public void insertBoard(BoardVO boardVO) {
		sqlSession.insert("insertBoard",boardVO);
		
	}


}
