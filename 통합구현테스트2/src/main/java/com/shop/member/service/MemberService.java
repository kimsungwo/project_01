package com.shop.member.service;

import com.shop.member.vo.MemberVO;

public interface MemberService {
	//회원가입
	void insertMember(MemberVO memberVO);
	
	//로그인
	MemberVO login(MemberVO memberVO);
}
