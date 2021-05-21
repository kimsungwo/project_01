package com.teamcoffee.member.service;

import com.teamcoffee.member.vo.MemberVO;

public interface MemberService {
	//일반회원 회원가입 처리
	void insertMember(MemberVO memberVO);
	//일반회원 로그인 처리
	MemberVO memberLoginProcess(MemberVO memberVO);
	//일반회원 회원정보조회 처리
	MemberVO memberInfo(MemberVO memberVO);
	//일반회원 탈퇴처리
	void deleteMember(MemberVO memberVO);
	//일반회원 프로필정보수정
	void myPageUpdate(MemberVO memberVO);
	//아이디 찾기 처리
	MemberVO find_id(MemberVO memberVO) throws Exception;
	
	
}
