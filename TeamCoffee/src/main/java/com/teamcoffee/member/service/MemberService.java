package com.teamcoffee.member.service;


import java.util.Date;
import java.util.List;

import com.teamcoffee.admin.vo.QnAViewVO;
import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.member.vo.PointVO;
import com.teamcoffee.member.vo.MemberMainVO;

public interface MemberService {
	//아이디 중복확인
	int memIdCheck(MemberVO memberVO);
	
	//이메일 중복확인
	int memEmailCheck(MemberVO memberVO);
	
	//salt값 셀렉트
	String getSaltByMemId(MemberVO memberVO);
	
	//일반회원 회원가입 처리
	void insertMember(MemberVO memberVO);
	
	//일반회원 로그인 처리
	MemberVO memberLoginProcess(MemberVO memberVO);
	
	//일반회원 회원정보조회 처리
	MemberVO memberInfo(MemberVO memberVO);
	
	//일반회원 탈퇴처리
	void leftMember(MemberVO memberVO);
	
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
	
	//로그인 유지
	void keepLogin(String memId, String sessionId, Date sessionLimit);
	
	//loginCookie로 회원정보 조회
	MemberVO checkLoginBefore(String value);
	
	//포인트 내역 추가
	int insertPointHistory(PointVO pointVO);
	
	//포인트 사용
	int updateMemPoint(MemberVO memberVO);
	
	//포인트 내역 조회
	List<PointVO> selectPointList(MemberVO memberVO);
	
	//주문 승인 및 취소 알림
	List<BuyViewVO> checkMemberConfirm(MemberVO memberVO);
	
	//메인페이지 정보
	MemberMainVO selectMemberMainInfo(MemberVO memberVO);
	
	//탈퇴 전 주문내역 검증
	boolean checkUnfinishedBuy(MemberVO memberVO);
	
	//포인트 내역 총합조회
	int selectMemPoint(MemberVO memberVO);
	
	//QnA 작성
	int insertQnAMember(BoardVO boardVO, MemberVO memberVO);
	
	//QnA 리스트
	List<QnAViewVO> selectQnAListToMember(QnAViewVO qnaViewVO);

}
