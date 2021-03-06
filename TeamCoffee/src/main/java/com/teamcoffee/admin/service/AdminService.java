package com.teamcoffee.admin.service;

import java.util.List;
import com.teamcoffee.admin.vo.AdminViewVO;
import com.teamcoffee.admin.vo.QnAViewVO;
import com.teamcoffee.board.vo.CommentVO;
import com.teamcoffee.cafe.vo.CafeVO;

public interface AdminService {
	

	
	//매장주 멤버관리 목록조회
	List<AdminViewVO> selectOwnerList(AdminViewVO adminViewVO);
	
	//멤버관리 목록조회
	List<AdminViewVO> selectMemberList(AdminViewVO adminViewVO);
	
	
	//매장주 상세조회
	AdminViewVO selectOwnerDetail(AdminViewVO adminViewVO);
	
	//일반회원 상세조회
	AdminViewVO selectMemberDetail(AdminViewVO adminViewVO);
	
	//일반회원 등급이름 조회
	String selectGradeName(AdminViewVO adminViewVO);
	
	//관리자 메인페이지 일반회원수 조회
	int selectAllMember();

	//관리자 메인페이지 매장주 회원수 조회
	int selectAllOwner();
	
	//매장신청대기목록 조회
	List<CafeVO> selectCreateReadyList();
	
	//매장신청 상세조회
	AdminViewVO selectCreateReadyDetail(AdminViewVO adminViewVO);
	
	//체인점 이름조회
	String selectChainName(String string);
	
	//매장주 정보 조회
	AdminViewVO selectOwnerInfo(String string);
	
	//매장 신청수 조회
	int selectAllCreateReady();
	
	//신규매장승인
	void newCafe(AdminViewVO adminViewVO);
	
	//QnA 리스트
	List<QnAViewVO> selectQnAList(QnAViewVO qnaViewVO);
	
	//QnA 상세보기
	QnAViewVO selectDetailQnA(QnAViewVO qnaViewVO);
	
	//QnA 댓글 리스트
	List<CommentVO> selectCommentQnA(QnAViewVO qnaViewVO);
	
	//QnA 댓글작성
	int insertQnAComment(CommentVO commentVO);
	
}
