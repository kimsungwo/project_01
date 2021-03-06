package com.teamcoffee.owner.vo;

import java.sql.Timestamp;
import java.util.Date;

//매장주 
public class OwnerVO {

 // 매장주 코드 
 private String ownerCode;

 // 매장주 아이디 
 private String ownerId;

 // 매장주 비밀번호 
 private String ownerPw;

 // 매장주 명 
 private String ownerName;

 // 매장주 생성날짜 
 private Date ownerRegDate;

 // 매장주 주소 
 private String ownerAddr;

 // 매장주 상세주소 
 private String ownerAddrDetail;

 // 매장주 폰번호 
 private String ownerTel;

 // 매장주 이메일 
 private String ownerEmail;
 
 //난수 SALT
 private String salt;
 
//관리자 확인
private String isAdmin;

//로그인유지 체크박스 유
private String useCookie;

//세션키 
private String sessionKey;

// 세션끝 
private Timestamp sessionLimit;

public String getSessionKey() {
	return sessionKey;
}

public void setSessionKey(String sessionKey) {
	this.sessionKey = sessionKey;
}

public Timestamp getSessionLimit() {
	return sessionLimit;
}

public void setSessionLimit(Timestamp sessionLimit) {
	this.sessionLimit = sessionLimit;
}

public String getUseCookie() {
	return useCookie;
}

public void setUseCookie(String useCookie) {
	this.useCookie = useCookie;
}

public String getIsAdmin() {
	return isAdmin;
}

public void setIsAdmin(String isAdmin) {
	this.isAdmin = isAdmin;
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

 public String getOwnerPw() {
     return ownerPw;
 }

 public void setOwnerPw(String ownerPw) {
     this.ownerPw = ownerPw;
 }

 public String getOwnerName() {
     return ownerName;
 }

 public void setOwnerName(String ownerName) {
     this.ownerName = ownerName;
 }

 public Date getOwnerRegDate() {
     return ownerRegDate;
 }

 public void setOwnerRegDate(Date ownerRegDate) {
     this.ownerRegDate = ownerRegDate;
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

 
 public String getSalt() {
	return salt;
}

public void setSalt(String salt) {
	this.salt = salt;
}

// DjvOwner 모델 복사
 public void CopyData(OwnerVO param)
 {
     this.ownerCode = param.getOwnerCode();
     this.ownerId = param.getOwnerId();
     this.ownerPw = param.getOwnerPw();
     this.ownerName = param.getOwnerName();
     this.ownerRegDate = param.getOwnerRegDate();
     this.ownerAddr = param.getOwnerAddr();
     this.ownerAddrDetail = param.getOwnerAddrDetail();
     this.ownerTel = param.getOwnerTel();
     this.ownerEmail = param.getOwnerEmail();
     this.salt = param.getSalt();
     this.isAdmin = param.getIsAdmin();
 }
}
