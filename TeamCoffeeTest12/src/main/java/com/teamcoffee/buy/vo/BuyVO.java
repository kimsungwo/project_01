package com.teamcoffee.buy.vo;

import java.util.Date;

public class BuyVO {
	// 구매 코드 
    private String buyCode;

    // 카페 코드 
    private String cafeCode;

    // 총 주문금액 
    private int totalPrice;

    // 결제 방식 
    private String paymentType;

    // 구매 시간 
    private Date buyDate;

    // 리뷰 여부 
    private String isReviewed;

    // 요청사항 
    private String buyRequests;

    // 구매상태 
    private String buyStatus;

    // 구매자 
    private String memCode;

    public String getBuyCode() {
        return buyCode;
    }

    public void setBuyCode(String buyCode) {
        this.buyCode = buyCode;
    }

    public String getCafeCode() {
        return cafeCode;
    }

    public void setCafeCode(String cafeCode) {
        this.cafeCode = cafeCode;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getIsReviewed() {
        return isReviewed;
    }

    public void setIsReviewed(String isReviewed) {
        this.isReviewed = isReviewed;
    }

    public String getBuyRequests() {
        return buyRequests;
    }

    public void setBuyRequests(String buyRequests) {
        this.buyRequests = buyRequests;
    }

    public String getBuyStatus() {
        return buyStatus;
    }

    public void setBuyStatus(String buyStatus) {
        this.buyStatus = buyStatus;
    }

    public String getMemCode() {
        return memCode;
    }

    public void setMemCode(String memCode) {
        this.memCode = memCode;
    }

    // DjvBuy 모델 복사
    public void CopyData(BuyVO param)
    {
        this.buyCode = param.getBuyCode();
        this.cafeCode = param.getCafeCode();
        this.totalPrice = param.getTotalPrice();
        this.paymentType = param.getPaymentType();
        this.buyDate = param.getBuyDate();
        this.isReviewed = param.getIsReviewed();
        this.buyRequests = param.getBuyRequests();
        this.buyStatus = param.getBuyStatus();
        this.memCode = param.getMemCode();
    }
}