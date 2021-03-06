package com.teamcoffee.member.service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamcoffee.admin.vo.QnAViewVO;
import com.teamcoffee.board.vo.BoardVO;
import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.cart.vo.CartVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.member.vo.PointVO;
import com.teamcoffee.member.vo.MemberMainVO;
import com.teamcoffee.util.sha256;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int memIdCheck(MemberVO memberVO) {
		String memId = sqlSession.selectOne("memIdCheck", memberVO);
		if(memId == null) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	@Override
	public int memEmailCheck(MemberVO memberVO) {
		String memEmail = sqlSession.selectOne("memEmailCheck", memberVO);
		if(memEmail == null) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	@Override
	public String getSaltByMemId(MemberVO memberVO) {
		return sqlSession.selectOne("getSaltByMemId", memberVO);
	}
	
	@Override
	public void insertMember(MemberVO memberVO) {
		String salt = sha256.generateSalt();
		memberVO.setSalt(salt);
		
		String memPw = memberVO.getMemPw();
		memPw = sha256.getEncrypt(memPw, salt);
		memberVO.setMemPw(memPw);
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
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void leftMember(MemberVO memberVO) {
		CartVO deleteCart = new CartVO();
		deleteCart.setMemCode(memberVO.getMemCode());
		deleteCart.setCartCode("");
		sqlSession.delete("deleteCart", deleteCart);
		sqlSession.delete("deleteLikeToMember", memberVO);
		sqlSession.update("leftMember",memberVO);
	}
	
	//회원정보 업데이트처리
	@Override
	public void myPageUpdate(MemberVO memberVO) {
		if(!memberVO.getMemPw().equals("")) {
			String salt = sha256.generateSalt();
			memberVO.setSalt(salt);
			
			String memPw = memberVO.getMemPw();
			memPw = sha256.getEncrypt(memPw, salt);
			memberVO.setMemPw(memPw);
		}
		String memTel = "";
		String tel = memberVO.getMemTel();
		if(tel.length() == 10) {
			memTel += tel.substring(0, 3) + "-";
			memTel += tel.substring(3, 6) + "-";
			memTel += tel.substring(tel.length()-4);
		}
		else if(tel.length() == 11) {
			memTel += tel.substring(0, 3) + "-";
			memTel += tel.substring(3, 7) + "-";
			memTel += tel.substring(tel.length()-4);
		}
		memberVO.setMemTel(memTel);
		sqlSession.update("myPageUpdate",memberVO);
	}

	//아이디 찾기 처리
	@Override 
	public MemberVO find_id(MemberVO memberVO){ 
		return sqlSession.selectOne("find_id", memberVO); 
	}
	//비밀번호 찾기 처리
	@Override
	public MemberVO find_pw(MemberVO memberVO) {
		return sqlSession.selectOne("find_pw",memberVO);
		
	}
	//비밀번호 12자리생성
	@Override
	public String getRamdomPassword() {
		char[] charSet = new char[] {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
				'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
				'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				'y', 'z', '!', '@', '#', '$', '%', '^', '&' 
		}; 
			StringBuffer sb = new StringBuffer(); 
			SecureRandom sr = new SecureRandom(); 
			sr.setSeed(new Date().getTime()); 
			int idx = 12; // 비밀번호 자릿수
			int len = charSet.length; 
			for (int i=0; i<12; i++) {  
				idx = sr.nextInt(len); // 강력한 난수를 발생시키기 위해 SecureRandom을 사용한다. 
				sb.append(charSet[idx]); 
			} 
			return sb.toString(); 
	}
	//비밀번호 변경처리
	@Override
	public void pwUpdate(MemberVO memberVO) {
		String salt = sha256.generateSalt();
		memberVO.setSalt(salt);
		
		String memPw = memberVO.getMemPw();
		memPw = sha256.getEncrypt(memPw, salt);
		memberVO.setMemPw(memPw);
		sqlSession.update("pwUpdate",memberVO);
	}
	//회원탈퇴 중간처리과정 
	@Override
	public MemberVO memberDropOut(MemberVO memberVO) {
		return sqlSession.selectOne("memberDropOut",memberVO);
	}

	@Override
	public void keepLogin(String memId, String sessionId, Date sessionLimit){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("memId", memId);
		paramMap.put("sessionId", sessionId);
		paramMap.put("sessionLimit", sessionLimit);
		
		sqlSession.update("keepLogin", paramMap);
	}

	@Override
	public MemberVO checkLoginBefore(String value){
		return sqlSession.selectOne("checkUserWithSessionKey", value);
	}

	//포인트 내역 추가
	@Override
	public int insertPointHistory(PointVO pointVO) {
		String buyCode = sqlSession.selectOne("selectMaxBuyCodeToPoint", pointVO);
		pointVO.setBuyCode(buyCode);
		return sqlSession.insert("insertPointHistory", pointVO);
	}

	//포인트 사용
	@Override
	public int updateMemPoint(MemberVO memberVO) {	
		return sqlSession.update("updateMemPoint", memberVO);
	}

	//포인트 내역 조회
	@Override
	public List<PointVO> selectPointList(MemberVO memberVO) {
		return sqlSession.selectList("selectPointList", memberVO);
	}

	@Override
	public List<BuyViewVO> checkMemberConfirm(MemberVO memberVO) {
		return sqlSession.selectList("checkMemberConfirm", memberVO);
	}

	@Override
	public MemberMainVO selectMemberMainInfo(MemberVO memberVO) {
		MemberMainVO result = new MemberMainVO();
		result.setBuys(sqlSession.selectOne("countBuyList", memberVO));
		result.setPoints(sqlSession.selectOne("selectMemPoint", memberVO));
		result.setCarts(sqlSession.selectOne("countCartList", memberVO));
		result.setLikes(sqlSession.selectOne("countLikeList", memberVO));
		result.setReviews(sqlSession.selectOne("countReviewList", memberVO));
		result.setQnas(sqlSession.selectOne("countQnASuccess", memberVO));
		return result;
	}

	@Override
	public boolean checkUnfinishedBuy(MemberVO memberVO) {
		List<BuyVO> result = sqlSession.selectList("checkUnfinishedBuy", memberVO);
		return result.size() == 0 ? true : false;
	}

	@Override
	public int selectMemPoint(MemberVO memberVO) {
		return sqlSession.selectOne("selectMemPoint",memberVO);
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public int insertQnAMember(BoardVO boardVO, MemberVO memberVO) {
		boardVO.setBoardCode("BOARD_5");
		int result1 = sqlSession.insert("boardUpload", boardVO);
		QnAViewVO qna = new QnAViewVO();
		int boardCode = sqlSession.selectOne("selectMaxBoardNumToQnA");
		qna.setQnaMemberType("member");
		qna.setBoardNum(boardCode);
		qna.setQnaWriterCode(memberVO.getMemCode());
		int result2 = sqlSession.insert("insertQnA", qna);
		
		return result1 + result2;
	}

	@Override
	public List<QnAViewVO> selectQnAListToMember(QnAViewVO qnaViewVO) {
		qnaViewVO.setQnaMemberType("member");
		return sqlSession.selectList("selectQnAList", qnaViewVO);
	}
}
	 

