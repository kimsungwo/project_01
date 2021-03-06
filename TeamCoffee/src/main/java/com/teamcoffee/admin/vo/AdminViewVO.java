package com.teamcoffee.admin.vo;

import java.util.Date;
import java.util.List;

import com.teamcoffee.member.vo.GradeVO;

//매장주 
public class AdminViewVO {

	// 매장주 코드
	private String ownerCode;

	// 매장주 아이디
	private String ownerId;

	// 매장주 명
	private String ownerName;

	// 매장주 생성날짜
	private String ownerRegDate;

	// 매장주 폰번호
	private String ownerTel;

	// 매장주 이메일
	private String ownerEmail;

	// 매장주 주소
	private String ownerAddr;

	// 매장주 상세주소
	private String ownerAddrDetail;

	//관리자 확인
	private String isAdmin;

	//회원코드 
	private String memCode;

	// 회원아이디 
	private String memId;

	// 회원가명 
	private String memNickname;

	// 회원생성일 
	private String memRegDate;

	// 회원폰번호 
	private String memTel;

	// 회원이메일 
	private String memEmail;

	// 회원주소 
	private String memAddr;

	// 회원상세주소 
	private String memAddrDetail;

	// 회원포인트 
	private int memPoint;

	// 회원등급 코드
	private String memGrade;

	// 회원프로필_이미지 
	private String memProfileImg;

	//등급 이름
	private String gradeName;

	//검색용 날짜
	private String preDate;
	private String nowDate;

	//아이디 검색용
	private String searchText;
	
	// 체인점코드 
	private String chainCode;

	// 체인점 명 
	private String chainName;

	// 카페코드 
	private String cafeCode;

	// 카페 이름 
	private String cafeName;

	// 카페운영시간 
	private String cafeHours;

	// 카페 폰번호 
	private String cafeTel;

	// 카페 주소 
	private String cafeAddr;

	// 카페 상세주소 
	private String cafeAddrDetail;

	// 카페 정보 
	private String cafeInfo;

	// 세스코유무 
	private String cafeCesco;
	
	// 카페 날짜 
	private String cafeRegDate;

	//카페생성상태
	private String createReady;

	public String getChainCode() {
		return chainCode;
	}

	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}

	public String getChainName() {
		return chainName;
	}

	public void setChainName(String chainName) {
		this.chainName = chainName;
	}

	public String getCafeCode() {
		return cafeCode;
	}

	public void setCafeCode(String cafeCode) {
		this.cafeCode = cafeCode;
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getCafeHours() {
		return cafeHours;
	}

	public void setCafeHours(String cafeHours) {
		this.cafeHours = cafeHours;
	}

	public String getCafeTel() {
		return cafeTel;
	}

	public void setCafeTel(String cafeTel) {
		this.cafeTel = cafeTel;
	}

	public String getCafeAddr() {
		return cafeAddr;
	}

	public void setCafeAddr(String cafeAddr) {
		this.cafeAddr = cafeAddr;
	}

	public String getCafeAddrDetail() {
		return cafeAddrDetail;
	}

	public void setCafeAddrDetail(String cafeAddrDetail) {
		this.cafeAddrDetail = cafeAddrDetail;
	}

	public String getCafeInfo() {
		return cafeInfo;
	}

	public void setCafeInfo(String cafeInfo) {
		this.cafeInfo = cafeInfo;
	}

	public String getCafeCesco() {
		return cafeCesco;
	}

	public void setCafeCesco(String cafeCesco) {
		this.cafeCesco = cafeCesco;
	}

	public String getCafeRegDate() {
		return cafeRegDate;
	}

	public void setCafeRegDate(String cafeRegDate) {
		this.cafeRegDate = cafeRegDate;
	}

	public String getCreateReady() {
		return createReady;
	}

	public void setCreateReady(String createReady) {
		this.createReady = createReady;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getOwnerAddr() {
		return ownerAddr;
	}

	public void setOwnerAddr(String ownerAddr) {
		this.ownerAddr = ownerAddr;
	}

	public String getOwnerAddrDetail() {
		return ownerAddrDetail;
	}

	public void setOwnerAddrDetail(String ownerAddrDetail) {
		this.ownerAddrDetail = ownerAddrDetail;
	}

	public String getMemAddr() {
		return memAddr;
	}

	public void setMemAddr(String memAddr) {
		this.memAddr = memAddr;
	}

	public String getMemAddrDetail() {
		return memAddrDetail;
	}

	public void setMemAddrDetail(String memAddrDetail) {
		this.memAddrDetail = memAddrDetail;
	}

	public int getMemPoint() {
		return memPoint;
	}

	public void setMemPoint(int memPoint) {
		this.memPoint = memPoint;
	}

	public String getMemGrade() {
		return memGrade;
	}

	public void setMemGrade(String memGrade) {
		this.memGrade = memGrade;
	}

	public String getMemProfileImg() {
		return memProfileImg;
	}

	public void setMemProfileImg(String memProfileImg) {
		this.memProfileImg = memProfileImg;
	}

	public String getPreDate() {
		return preDate;
	}

	public void setPreDate(String preDate) {
		this.preDate = preDate;
	}

	public String getNowDate() {
		return nowDate;
	}

	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}

	public String getOwnerCode() {
		return ownerCode;
	}

	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	public String getOwnerRegDate() {
		return ownerRegDate;
	}

	public void setOwnerRegDate(String ownerRegDate) {
		this.ownerRegDate = ownerRegDate;
	}

	public String getOwnerTel() {
		return ownerTel;
	}

	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}

	public String getMemCode() {
		return memCode;
	}

	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemNickname() {
		return memNickname;
	}

	public void setMemNickname(String memNickname) {
		this.memNickname = memNickname;
	}

	public String getMemRegDate() {
		return memRegDate;
	}

	public void setMemRegDate(String memRegDate) {
		this.memRegDate = memRegDate;
	}

	public String getMemTel() {
		return memTel;
	}

	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String adminViewVO) {
		this.gradeName = adminViewVO;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	
// DjvManage 모델
	public void CopyDataManage(AdminViewVO param) {
		this.ownerCode = param.getOwnerCode();
		this.ownerId = param.getOwnerId();
		this.ownerName = param.getOwnerName();
		this.ownerRegDate = param.getOwnerRegDate();
		this.ownerTel = param.getOwnerTel();
		this.ownerEmail = param.getOwnerEmail();
		this.memCode = param.getMemCode();
		this.memEmail = param.getMemEmail();
		this.memId = param.getMemId();
		this.memNickname = param.getMemNickname();
		this.memRegDate = param.getMemRegDate();
		this.memTel = param.getMemTel();
	}
	
}
