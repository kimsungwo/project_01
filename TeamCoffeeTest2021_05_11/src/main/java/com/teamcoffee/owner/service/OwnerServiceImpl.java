package com.teamcoffee.owner.service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.owner.vo.OwnerVO;
import com.teamcoffee.util.sha256;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService{
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public int ownerIdCheck(OwnerVO ownerVO) {
		String ownerId = sqlSession.selectOne("ownerIdCheck", ownerVO);
		if(ownerId == null) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	@Override
	public int ownerEmailCheck(OwnerVO ownerVO) {
		String ownerEmail = sqlSession.selectOne("ownerEmailCheck", ownerVO);
		if(ownerEmail == null) {
			return 0;
		}
		else {
			return 1;
		}
	}
	
	@Override
	public String getSaltByOwnerId(OwnerVO ownerVO) {
		return sqlSession.selectOne("getSaltByOwnerId", ownerVO);
	}
	
	@Override
	public void insertOwner(OwnerVO ownerVO) {
		String salt = sha256.generateSalt();
		ownerVO.setSalt(salt);
		
		String ownerPw = ownerVO.getOwnerPw();
		ownerPw = sha256.getEncrypt(ownerPw, salt);
		ownerVO.setOwnerPw(ownerPw);
		sqlSession.insert("insertOwner", ownerVO);
	}

	@Override
	public OwnerVO ownerLoginProcess(OwnerVO ownerVO) {
		return sqlSession.selectOne("ownerLoginProcess", ownerVO);
	}

	@Override
	public OwnerVO selectOwnerInfo(OwnerVO ownerVO) {
		return sqlSession.selectOne("selectOwnerInfo", ownerVO);
	}

	@Override
	public void insertCafe(CafeVO cafeVO) {
		sqlSession.insert("insertCafe", cafeVO);
		
	}

	@Override
	public String selectChainLogo(CafeChainVO cafeChainVO) {
		return sqlSession.selectOne("selectChainLogo", cafeChainVO);
	}

	@Override
	public List<CafeVO> CafeInfoList(OwnerVO ownerVO) {
		return sqlSession.selectList("CafeInfoList", ownerVO);
	}

	@Override
	public CafeVO selectCafeInfo(CafeVO cafeVO) {
		return sqlSession.selectOne("selectCafeInfo", cafeVO);
	}

	@Override
	public void cafeInfoUpdate(CafeVO cafeVO) {
		sqlSession.update("cafeInfoUpdate", cafeVO);
	}

	@Override
	public void deleteCafe(CafeVO cafeVO) {
		sqlSession.delete("deleteCafe", cafeVO);
	}
	
	// 매장주 프로필 정보수정
	@Override
	public void myPageUpdateOwner(OwnerVO ownerVO) {
		if(!ownerVO.getOwnerPw().equals("")) {
			String salt = sha256.generateSalt();
			ownerVO.setSalt(salt);
			
			String ownerPw = ownerVO.getOwnerPw();
			ownerPw = sha256.getEncrypt(ownerPw, salt);
			ownerVO.setOwnerPw(ownerPw);
		}
		sqlSession.update("myPageUpdateOwner", ownerVO);
	}

	// 회원탈퇴 중간처리과정
	@Override
	public OwnerVO OwnerDropOut(OwnerVO ownerVO) {
		return sqlSession.selectOne("ownerDropOut", ownerVO);
	}

	// 매장주 탈퇴처리
	@Override
	public void deleteOwner(OwnerVO ownerVO) {
		sqlSession.delete("deleteOwner", ownerVO);
	}
	//아이디 찾기 처리
	@Override
	public OwnerVO find_idOwner(OwnerVO ownerVO) {
		return sqlSession.selectOne("find_idOwner", ownerVO);
	}
	//비밀번호 찾기 처리
	@Override
	public OwnerVO find_pwOwner(OwnerVO ownerVO) {
		return sqlSession.selectOne("find_pwOwner", ownerVO);
	}
	//비밀번호 12자리생성
	@Override
	public String getRamdomPasswordOwner() {
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
	public void pwUpdateOwner(OwnerVO ownerVO) {
		String salt = sha256.generateSalt();
	    ownerVO.setSalt(salt);
			
		String ownerPw = ownerVO.getOwnerPw();
		ownerPw = sha256.getEncrypt(ownerPw, salt);
		ownerVO.setOwnerPw(ownerPw);
		sqlSession.update("pwUpdateOwner",ownerVO);
	}
	
	@Override
	public void ownerKeepLogin(String ownerId, String sessionId, Date sessionLimit){
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("ownerId", ownerId);
		paramMap.put("sessionId", sessionId);
		paramMap.put("sessionLimit", sessionLimit);
		
		sqlSession.update("ownerKeepLogin", paramMap);
	}

	@Override
	public OwnerVO ownerCheckLoginBefore(String value){
		return sqlSession.selectOne("checkOwnerWithSessionKey", value);
	}

	@Override
	public List<BuyViewVO> selectOrderList(BuyVO buyVO) {
		return sqlSession.selectList("selectOrderList", buyVO);
	}

	@Override
	public List<BuyViewVO> renameOrderNames(BuyVO buyVO) {
		return sqlSession.selectList("renameOrderNames", buyVO);
	}

	@Override
	public List<BuyViewVO> checkOrderConfirm(OwnerVO ownerVO) {
		List<CafeVO> cafeCodes = sqlSession.selectList("selectCafeCodeToOwner", ownerVO);
		return sqlSession.selectList("checkOrderConfirm", cafeCodes);
	}

	@Override
	public List<CafeVO> selectCafeCodeToOwner(OwnerVO ownerVO) {
		return sqlSession.selectList("selectCafeCodeToOwner", ownerVO);
	}


}
