package com.teamcoffee.owner.service;

import java.util.Date;
import java.util.List;

import com.teamcoffee.buy.vo.BuyVO;
import com.teamcoffee.buy.vo.BuyViewVO;
import com.teamcoffee.cafe.vo.CafeChainVO;
import com.teamcoffee.cafe.vo.CafeVO;
import com.teamcoffee.member.vo.MemberVO;
import com.teamcoffee.owner.vo.OwnerMainVO;
import com.teamcoffee.owner.vo.OwnerManageViewVO;
import com.teamcoffee.owner.vo.OwnerVO;

public interface OwnerService {
	//아이디 중복확인
	int ownerIdCheck(OwnerVO ownerVO);
	
	//이메일 중복확인
	int ownerEmailCheck(OwnerVO ownerVO);
	
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
	int deleteCafe(CafeVO cafeVO);
	
	//매장주 프로필정보수정
	void myPageUpdateOwner(OwnerVO ownerVO);
	
	//회원탈퇴 중간처리과정
	OwnerVO OwnerDropOut(OwnerVO ownerVO);	
	
	//매장주 회원 탈퇴처리
	void leftOwner(OwnerVO ownerVO);
	
	//아이디 찾기 처리
	OwnerVO find_idOwner(OwnerVO ownerVO);
	
	//비밀번호 찾기 처리
	OwnerVO find_pwOwner(OwnerVO ownerVO);
	
	//난수생성
	String getRamdomPasswordOwner();
	
	//비밀번호 단독변경처리
	void pwUpdateOwner(OwnerVO ownerVO);
	
	//로그인 유지
    void ownerKeepLogin(String ownerId, String sessionId, Date sessionLimit);
    
	//loginCookie로 회원정보 조회
	OwnerVO ownerCheckLoginBefore(String value);
	
	//예약확인 페이지 주문 목록
	List<BuyViewVO> selectOrderList(BuyVO buyVO);
	
	//예약확인 페이지 메뉴이름 지정
	List<BuyViewVO> renameOrderNames(BuyVO buyVO);
	
	//매장주의 매장리스트 가져오기
	List<CafeVO> selectCafeCodeToOwner(OwnerVO ownerVO);
	
	//새로운 주문 확인 알림
	List<BuyViewVO> checkOrderConfirm(OwnerVO ownerVO);
	
	//매장주 멤버관리 목록조회
	List<OwnerManageViewVO> selectOwnerList(OwnerManageViewVO ownerManageViewVO);
	
	//멤버관리 목록조회
	List<OwnerManageViewVO> selectMemberList(OwnerManageViewVO ownerManageViewVO);
	
	//처리안된 주문 체크
	boolean checkBuyStatusToCafe(CafeVO cafeVO);
	
	//탈퇴전 폐점매장 검증
	boolean checkCafeClosed(OwnerVO ownerVO);
	
	//매장주 메인페이지 정보
	OwnerMainVO selectOwnerMainVO(OwnerVO ownerVO);
	
	//매장 영업상태 변경
	void updateCafeState(CafeVO cafeVO);
}
