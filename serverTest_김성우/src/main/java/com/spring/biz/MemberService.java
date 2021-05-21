package com.spring.biz;


import com.spring.vo.MemberVO;

public interface MemberService {
	void insertMember(MemberVO memberVO);
	
	MemberVO login(MemberVO memberVO);
}
