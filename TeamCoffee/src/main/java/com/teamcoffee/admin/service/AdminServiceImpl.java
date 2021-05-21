package com.teamcoffee.admin.service;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamcoffee.admin.vo.AdminViewVO;
import com.teamcoffee.admin.vo.QnAViewVO;
import com.teamcoffee.board.vo.CommentVO;
import com.teamcoffee.cafe.vo.CafeVO;

import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//멤버관리 목록조회
	@Override
	public List<AdminViewVO> selectMemberList(AdminViewVO adminViewVO) {
		return sqlSession.selectList("selectMemberList",adminViewVO); 
	}
	
	//매장주 멤버관리 목록조회
	@Override
	public List<AdminViewVO> selectOwnerList(AdminViewVO adminViewVO) {
		return sqlSession.selectList("selectOwnerList",adminViewVO); 
	}
	
	//매장주 상세조회
	@Override
	public AdminViewVO selectOwnerDetail(AdminViewVO adminViewVO) {
		return sqlSession.selectOne("selectOwnerDetail",adminViewVO);
	}
	//일반회원 상세조회
	@Override
	public AdminViewVO selectMemberDetail(AdminViewVO adminViewVO) {
		return sqlSession.selectOne("selectMemberDetail",adminViewVO);
		
		
	}

	//일반회원 등급이름 조회
	@Override
	public String selectGradeName(AdminViewVO adminViewVO) {
		return sqlSession.selectOne("selectGradeName",adminViewVO);
	}
	
	//관리자 메인페이지 일반회원수 조회
	@Override
	public int selectAllMember() {
		return sqlSession.selectOne("selectAllMember");
	}

	//관리자 메인페이지 매장주 회원수 조회
	@Override
	public int selectAllOwner() {
		return sqlSession.selectOne("selectAllOwner");
	}
	
	//매장신청대기목록 조회
	@Override
	public List<CafeVO> selectCreateReadyList() {
		return sqlSession.selectList("selectCreateReadyList");
	}
		
	//매장신청 상세조회
	@Override
	public AdminViewVO selectCreateReadyDetail(AdminViewVO adminViewVO) {
		return sqlSession.selectOne("selectCreateReadyDetail",adminViewVO); 
	}
	//체인점 이름조회
	@Override
	public String selectChainName(String string) {
		return sqlSession.selectOne("selectChainName",string);
	}
	//매장주 정보 조회
	@Override
	public AdminViewVO selectOwnerInfo(String string) {
		return sqlSession.selectOne("selectOwnerInfoAdmin",string);
	}

	//매장 신청수 조회
	@Override
	public int selectAllCreateReady() {
		return sqlSession.selectOne("selectAllCreateReady");
	}

	//신규매장승인
	@Override
	public void newCafe(AdminViewVO adminViewVO) {
		sqlSession.update("newCafe",adminViewVO);
		
	}
	
	//QnA 리스트
	@Override
	public List<QnAViewVO> selectQnAList(QnAViewVO qnaViewVO) {
		return sqlSession.selectList("selectQnAList", qnaViewVO);
	}

	@Override
	public QnAViewVO selectDetailQnA(QnAViewVO qnaViewVO) {
		return sqlSession.selectOne("selectDetailQnA", qnaViewVO);
	}

	@Override
	public List<CommentVO> selectCommentQnA(QnAViewVO qnaViewVO) {
		return sqlSession.selectList("selectCommentQnA", qnaViewVO);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertQnAComment(CommentVO commentVO) {
		int result1 = sqlSession.insert("insertComment", commentVO);
		int result2 = sqlSession.update("updateIsAnswer", commentVO);
		return result1 + result2;
	}
	
}
