package com.teamcoffee.member.service;

import com.teamcoffee.member.vo.MemberVO;

public interface MemberService {
	//아이디 중복확인
	String memIdCheck(MemberVO memberVO);
	//이메일 중복확인
	String memEmailCheck(MemberVO memberVO);
	//salt값 셀렉트
	String getSaltByMemId(MemberVO memberVO);
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
	MemberVO find_id(MemberVO memberVO);
	//비밀번호 찾기 처리
	MemberVO find_pw(MemberVO memberVO);
	//난수생성
	String getRamdomPassword();
	//비밀번호 단독변경처리
	void pwUpdate(MemberVO memberVO);
	//회원탈퇴 중간처리과정
	MemberVO memberDropOut(MemberVO memberVO);
	
}
