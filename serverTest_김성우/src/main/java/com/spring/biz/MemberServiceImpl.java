package com.spring.biz;




import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.vo.MemberVO;

//@Component /* 스프링에서 쓰는 어노테이션. 자동완성됨. 실행될때 자동으로 클래스생성해줌.얘도 상속을 하고있다. */
//단 ,자동객체생성위해선  servlet-context.xml(컨트롤러설정파일)에 component-scan태그가 있어야됨

			
@Service("memberService") //@Component 이거랑 같음. 객체 생성때" "안으로 객체명을 만들어줌
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	

	@Override
	public void insertMember(MemberVO memberVO) {
		sqlSession.insert("insertMember",memberVO);
	}


	@Override
	public MemberVO login(MemberVO memberVO) {
		return sqlSession.selectOne("login", memberVO);
	}
	
}
