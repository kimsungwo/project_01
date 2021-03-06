package com.teamcoffee.cafe.vo;

import java.util.Date;
import java.util.List;

import com.teamcoffee.menu.vo.MenuVO;

//카페 
public class CafeVO {

 // 카페코드 
 private String cafeCode;

 // 카페 이름 
 private String cafeName;

 // 매장 코드 
 private String ownerCode;

 // 체인점 코드 
 private String chainCode;

 // 카페운영시간 
 private String cafeHours;

 // 카페 폰번호 
 private String cafeTel;

 // 카페 주소 
 private String cafeAddr;

 // 카페 상세주소 
 private String cafeAddrDetail;

 // 카페 로고 
 private String cafeLogo;

 // 카페 정보 
 private String cafeInfo;

 // 카페STAR 
 private double cafeStar;

 // 카페리뷰 횟수 
 private int cafeReviewCnt;

 // 세스코유무 
 private String cafeCesco;

 // 카페 날짜 
 private Date cafeRegDate;

 // 카페 상태 
 private String cafeState;

 // 위도 
 private String cafeLatitude;

 // 경도 
 private String cafeLongitude;

 //운영시간 배열
 private String[] cafeHoursArray;
 
 //좋아요 클릭 판단을 위한 변수
 private String likeCheck;
 
 //카페 목록 조회 시 좋아요 정보도 조회하려면 아이디값이 필요하기 때문에 추가
 private String memCode;
 
 //현위치에서 카페와 거리
 private String distance;
 
 //카페리스트 정렬
 private String order;
 
 //카페생성상태
 private String createReady;
 
 //카페 폐업여부
 private String cafeClosed;
 
 
 
 
 
 
 
 public String getCafeClosed() {
	return cafeClosed;
}

public void setCafeClosed(String cafeClosed) {
	this.cafeClosed = cafeClosed;
}

private List<MenuVO> menuCodes;
 
 public List<MenuVO> getMenuCodes() {
	return menuCodes;
}

public void setMenuCodes(List<MenuVO> menuCodes) {
	this.menuCodes = menuCodes;
}

public String getCreateReady() {
	return createReady;
}

public void setCreateReady(String createReady) {
	this.createReady = createReady;
}

public void setChainCode(String chainCode) {
	this.chainCode = chainCode;
}

public String getOrder() {
	return order;
}

public void setOrder(String order) {
	this.order = order;
}

public String getDistance() {
	return distance;
}

public void setDistance(String distance) {
	this.distance = distance;
}

public String getMemCode() {
	return memCode;
}

public void setMemCode(String memCode) {
	this.memCode = memCode;
}

public String getLikeCheck() {
	return likeCheck;
}

public void setLikeCheck(String likeCheck) {
	this.likeCheck = likeCheck;
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

 public String getOwnerCode() {
     return ownerCode;
 }

 public void setOwnerCode(String ownerCode) {
     this.ownerCode = ownerCode;
 }

 public String getChainCode() {
     return chainCode;
 }

 public void setchainCode(String chainCode) {
     this.chainCode = chainCode;
 }

 public String getCafeHours() {
	 if(cafeHoursArray != null) {
		 return cafeHoursArray[0] + " ~ " + cafeHoursArray[1];
	 }
	 else {
		 return cafeHours;
	 }
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

 public String getCafeLogo() {
     return cafeLogo;
 }

 public void setCafeLogo(String cafeLogo) {
     this.cafeLogo = cafeLogo;
 }

 public String getCafeInfo() {
     return cafeInfo;
 }

 public void setCafeInfo(String cafeInfo) {
     this.cafeInfo = cafeInfo;
 }

 public double getCafeStar() {
     return cafeStar;
 }

 public void setCafeStar(double cafeStar) {
     this.cafeStar = cafeStar;
 }

 public int getCafeReviewCnt() {
     return cafeReviewCnt;
 }

 public void setCafeReviewCnt(int cafeReviewCnt) {
     this.cafeReviewCnt = cafeReviewCnt;
 }

 public String getCafeCesco() {
     return cafeCesco;
 }

 public void setCafeCesco(String cafeCesco) {
     this.cafeCesco = cafeCesco;
 }


 public Date getCafeRegDate() {
	return cafeRegDate;
}

public void setCafeRegDate(Date cafeRegDate) {
	this.cafeRegDate = cafeRegDate;
}

public String getCafeState() {
     return cafeState;
 }

 public void setCafeState(String cafeState) {
     this.cafeState = cafeState;
 }

 public String getCafeLatitude() {
     return cafeLatitude;
 }

 public void setCafeLatitude(String cafeLatitude) {
     this.cafeLatitude = cafeLatitude;
 }

 public String getCafeLongitude() {
     return cafeLongitude;
 }

 public void setCafeLongitude(String cafeLongitude) {
     this.cafeLongitude = cafeLongitude;
 }
 
 public String[] getCafeHoursArray() {
	return cafeHoursArray;
}

public void setCafeHoursArray(String[] cafeHoursArray) {
	this.cafeHoursArray = cafeHoursArray;
}

// DjvCafe 모델 복사
 public void CopyData(CafeVO param)
 {
     this.cafeCode = param.getCafeCode();
     this.cafeName = param.getCafeName();
     this.ownerCode = param.getOwnerCode();
     this.chainCode = param.getChainCode();
     this.cafeHours = param.getCafeHours();
     this.cafeTel = param.getCafeTel();
     this.cafeAddr = param.getCafeAddr();
     this.cafeAddrDetail = param.getCafeAddrDetail();
     this.cafeLogo = param.getCafeLogo();
     this.cafeInfo = param.getCafeInfo();
     this.cafeStar = param.getCafeStar();
     this.cafeReviewCnt = param.getCafeReviewCnt();
     this.cafeCesco = param.getCafeCesco();
     this.cafeRegDate = param.getCafeRegDate();
     this.cafeState = param.getCafeState();
     this.cafeLatitude = param.getCafeLatitude();
     this.cafeLongitude = param.getCafeLongitude();
 }


}
