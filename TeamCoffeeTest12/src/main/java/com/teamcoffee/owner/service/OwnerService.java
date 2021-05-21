package com.teamcoffee.owner.service;

import java.util.List;

import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.owner.vo.OwnerVO;

public interface OwnerService {
	//아이디 중복확인
	String ownerIdCheck(OwnerVO ownerVO);
	//이메일 중복확인
	String ownerEmailCheck(OwnerVO ownerVO);
	//salt값 셀렉트
	String getSaltByOwnerId(OwnerVO ownerVO);
	//매장주 회원가입 처리
	void insertOwner(OwnerVO ownerVO);
	//매장주 로그인 처리
	OwnerVO ownerLoginProcess(OwnerVO ownerVO);
	//매장주 프로필 조회
	OwnerVO selectOwnerInfo(OwnerVO ownerVO);
	//매장 등록 처리
	void insertCafe(CafeVO cafeVO);
	//체인점 변경시 로고변화
	String selectChainLogo(CafeChainVO cafeChainVO);
	//매장주에 따른 매장조회
	List<CafeVO> CafeInfoList(OwnerVO ownerVO);
	//매장별 정보조회
	CafeVO selectCafeInfo(CafeVO cafeVO);
	//매장 정보 수정
	void cafeInfoUpdate(CafeVO cafeVO);
	//매장 삭제
	void deleteCafe(CafeVO cafeVO);
	
	
	//매장주 프로필정보수정
	void myPageUpdateOwner(OwnerVO ownerVO);
	//매장주 회원 탈퇴처리
	void deleteOwner(OwnerVO ownerVO);
	//아이디 찾기 처리
	OwnerVO find_id(OwnerVO ownerVO);
	//비밀번호 찾기 처리
	OwnerVO find_pw(OwnerVO ownerVO);
	//난수생성
	String getRamdomPassword();
	//비밀번호 단독변경처리
	void pwUpdate(OwnerVO ownerVO);
	//회원탈퇴 중간처리과정
	OwnerVO OwnerDropOut(OwnerVO ownerVO);
	
	
	
	
	
}
