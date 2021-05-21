package com.teamcoffee.member.vo;

import java.util.Date;

import com.teamcoffee.buy.vo.BuyVO;

public class PointVO {
	// 포인트 내역 코드 
    private String pointCode;

    // 회원 코드 
    private String memCode;

    // 포인트 변동사항 
    private String pointChangeName;

    // 포인트 변동량 
    private int pointChange;

    // 포인트 변동날짜 
    private Date pointDate;
    
    // 구매 코드 
    private String buyCode;
    
    private BuyVO buyVO;
    
    public BuyVO getBuyVO() {
		return buyVO;
	}

	public void setBuyVO(BuyVO buyVO) {
		this.buyVO = buyVO;
	}

	public String getPointCode() {
        return pointCode;
    }

    public void setPointCode(String pointCode) {
        this.pointCode = pointCode;
    }

    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    public String getPointChangeName() {
        return pointChangeName;
    }

    public void setPointChangeName(String pointChangeName) {
        this.pointChangeName = pointChangeName;
    }

    public int getPointChange() {
        return pointChange;
    }

    public void setPointChange(int pointChange) {
        this.pointChange = pointChange;
    }

    public Date getPointDate() {
        return pointDate;
    }

    public void setPointDate(Date pointDate) {
        this.pointDate = pointDate;
    }

    public String getBuyCode() {
        return buyCode;
    }

    public void setBuyCode(String buyCode) {
        this.buyCode = buyCode;
    }
    
    // DjvPoint 모델 복사
    public void CopyData(PointVO param)
    {
        this.pointCode = param.getPointCode();
        this.memCode = param.getMemCode();
        this.pointChangeName = param.getPointChangeName();
        this.pointChange = param.getPointChange();
        this.pointDate = param.getPointDate();
        this.buyCode = param.getBuyCode();
    }
}
