package com.teamcoffee.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.member.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public void insertMember(MemberVO memberVO) {
		sqlSession.insert("insertMember", memberVO);
		
	}

	@Override
	public MemberVO memberLoginProcess(MemberVO memberVO) {
		return sqlSession.selectOne("memberLoginProcess", memberVO);
	}

	@Override
	public MemberVO memberInfo(MemberVO memberVO) {
		return sqlSession.selectOne("memberInfo", memberVO);
	}

	//회원탈퇴 처리
	@Override
	public void deleteMember(MemberVO memberVO) {
		sqlSession.delete("deleteMember",memberVO);
	}
	//회원정보 업데이트처리
	@Override
	public void myPageUpdate(MemberVO memberVO) {
		sqlSession.update("myPageUpdate",memberVO);
	}
	
	//아이디 찾기 처리
	@Override
	public MemberVO find_id(MemberVO memberVO) throws Exception{
		return sqlSession.selectOne("find_id", memberVO);
	}
}
