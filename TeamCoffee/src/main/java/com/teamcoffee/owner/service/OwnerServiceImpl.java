package com.teamcoffee.owner.service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.menu.vo.MenuVO;
import com.teamcoffee.owner.vo.OwnerMainVO;
import com.teamcoffee.owner.vo.OwnerManageViewVO;
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
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteCafe(CafeVO cafeVO) {
		int result1 = sqlSession.update("closeCafe", cafeVO);
		int result2 = 0;
		List<MenuVO> menuCodes = sqlSession.selectList("selectMenuCodeToCafe", cafeVO);
		if(menuCodes.size() != 0) {
			cafeVO.setMenuCodes(menuCodes);
			result2 = sqlSession.delete("deleteCartToCafe", cafeVO);
		}
		int result3 = sqlSession.delete("deleteLikeToCafe", cafeVO);
		return result1 + result2 + result3;
	}
	
	// ????????? ????????? ????????????
	@Override
	public void myPageUpdateOwner(OwnerVO ownerVO) {
		if(!ownerVO.getOwnerPw().equals("")) {
			String salt = sha256.generateSalt();
			ownerVO.setSalt(salt);
			
			String ownerPw = ownerVO.getOwnerPw();
			ownerPw = sha256.getEncrypt(ownerPw, salt);
			ownerVO.setOwnerPw(ownerPw);
		}
		String memTel = "";
		String tel = ownerVO.getOwnerTel();
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
		ownerVO.setOwnerTel(memTel);
		sqlSession.update("myPageUpdateOwner", ownerVO);
	}

	// ???????????? ??????????????????
	@Override
	public OwnerVO OwnerDropOut(OwnerVO ownerVO) {
		return sqlSession.selectOne("ownerDropOut", ownerVO);
	}

	// ????????? ????????????
	@Override
	public void leftOwner(OwnerVO ownerVO) {
		sqlSession.update("leftOwner", ownerVO);
	}
	//????????? ?????? ??????
	@Override
	public OwnerVO find_idOwner(OwnerVO ownerVO) {
		return sqlSession.selectOne("find_idOwner", ownerVO);
	}
	//???????????? ?????? ??????
	@Override
	public OwnerVO find_pwOwner(OwnerVO ownerVO) {
		return sqlSession.selectOne("find_pwOwner", ownerVO);
	}
	//???????????? 12????????????
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
			int idx = 12; // ???????????? ?????????
			int len = charSet.length; 
			for (int i=0; i<12; i++) {  
				idx = sr.nextInt(len); // ????????? ????????? ??????????????? ?????? SecureRandom??? ????????????. 
				sb.append(charSet[idx]); 
			} 
		return sb.toString(); 
	}
	//???????????? ????????????
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

	//???????????? ????????????
	@Override
	public List<OwnerManageViewVO> selectMemberList(OwnerManageViewVO ownerManageViewVO) {
		return sqlSession.selectList("selectMemberList",ownerManageViewVO); 
	}
	
	//????????? ???????????? ????????????
	@Override
	public List<OwnerManageViewVO> selectOwnerList(OwnerManageViewVO ownerManageViewVO) {
		return sqlSession.selectList("selectOwnerList",ownerManageViewVO); 
	}

	@Override
	public boolean checkBuyStatusToCafe(CafeVO cafeVO) {
		List<BuyVO> result = sqlSession.selectList("checkBuyStatusToCafe", cafeVO);
		return result.size() == 0 ? true : false;
	}

	@Override
	public boolean checkCafeClosed(OwnerVO ownerVO) {
		List<CafeVO> result = sqlSession.selectList("checkCafeClosed", ownerVO);
		return result.size() == 0 ? true : false;
	}

	@Override
	public OwnerMainVO selectOwnerMainVO(OwnerVO ownerVO) {
		OwnerMainVO result = new OwnerMainVO();
		result.setAprCafes(sqlSession.selectOne("countAprCafes", ownerVO));
		result.setOprtCafes(sqlSession.selectOne("countOprtCafes", ownerVO));
		List<CafeVO> list = sqlSession.selectList("selectCafeCodeToOwner", ownerVO);
		if(list.size() == 0) {
			result.setOrders(0);
		}
		else {
			result.setOrders(sqlSession.selectOne("countOrders", list));
		}
		return result;
	}

	@Override
	public void updateCafeState(CafeVO cafeVO) {
		sqlSession.update("updateCafeState", cafeVO);
	}
}
