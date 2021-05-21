package com.teamcoffee.owner.service;

import java.util.List;

import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.owner.vo.OwnerVO;

public interface OwnerService {
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
}
