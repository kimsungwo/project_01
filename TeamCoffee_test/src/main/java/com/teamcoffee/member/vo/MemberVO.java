package com.teamcoffee.member.vo;

import java.sql.Timestamp;
//import java.util.Date;

// 회원정보 테이블 
public class MemberVO {

    // 회원코드 
    private String memCode;

    // 회원아이디 
    private String memId;

    // 회원비밀번호 
    private String memPw;

    // 회원가명 
    private String memNickname;

    // 회원생성일 
    private String memRegDate; //자료형 date->String변경

    // 회원주소 
    private String memAddr;

    // 회원상세주소 
    private String memAddrDetail;

    // 회원폰번호 
    private String memTel;

    // 회원포인트 
    private int memPoint;

    // 회원등급 
    private String memGrade;

    // 회원프로필_이미지 
    private String memProfileImg;

    // 회원탈퇴여부 
    private String memLeft;

    // 세션키 
    private String sessionKey;

    // 세션끝 
    private Timestamp sessionLimit;

    // 회원이메일 
    private String memEmail;

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

    public String getMemPw() {
        return memPw;
    }

    public void setMemPw(String memPw) {
        this.memPw = memPw;
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

    public String getMemTel() {
        return memTel;
    }

    public void setMemTel(String memTel) {
        this.memTel = memTel;
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

    public String getMemLeft() {
        return memLeft;
    }

    public void setMemLeft(String memLeft) {
        this.memLeft = memLeft;
    }

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

    public String getMemEmail() {
        return memEmail;
    }

    public void setMemEmail(String memEmail) {
        this.memEmail = memEmail;
    }

    // Membervo 모델 복사
    public void CopyData(MemberVO param)
    {
        this.memCode = param.getMemCode();
        this.memId = param.getMemId();
        this.memPw = param.getMemPw();
        this.memNickname = param.getMemNickname();
        this.memRegDate = param.getMemRegDate();
        this.memAddr = param.getMemAddr();
        this.memAddrDetail = param.getMemAddrDetail();
        this.memTel = param.getMemTel();
        this.memPoint = param.getMemPoint();
        this.memGrade = param.getMemGrade();
        this.memProfileImg = param.getMemProfileImg();
        this.memLeft = param.getMemLeft();
        this.sessionKey = param.getSessionKey();
        this.sessionLimit = param.getSessionLimit();
        this.memEmail = param.getMemEmail();
    }

	@Override
	public String toString() {
		return "Membervo [getMemCode()=" + getMemCode() + ", getMemId()=" + getMemId() + ", getMemPw()="
				+ getMemPw() + ", getMemNickname()=" + getMemNickname() + ", getMemRegDate()=" + getMemRegDate()
				+ ", getMemAddr()=" + getMemAddr() + ", getMemAddrDetail()=" + getMemAddrDetail() + ", getMemTel()="
				+ getMemTel() + ", getMemPoint()=" + getMemPoint() + ", getMemGrade()=" + getMemGrade()
				+ ", getMemProfileImg()=" + getMemProfileImg() + ", getMemLeft()=" + getMemLeft()
				+ ", getSessionKey()=" + getSessionKey() + ", getSessionLimit()=" + getSessionLimit()
				+ ", getMemEmail()=" + getMemEmail() + "]";
	}
	
}
