package com.teamcoffee.buy.vo;

public class BuyDetailVO {
	// 구매 상세 코드 
    private String buyDetailCode;

    // 구매 코드 
    private String buyCode;

    // 메뉴 코드 
    private String menuCode;

    // 구매량 
    private int buyQuantity;
    
    // 개별 가격 
    private int buyPrice;
    
	public String getBuyDetailCode() {
        return buyDetailCode;
    }

    public void setBuyDetailCode(String buyDetailCode) {
        this.buyDetailCode = buyDetailCode;
    }

    public String getBuyCode() {
        return buyCode;
    }

    public void setBuyCode(String buyCode) {
        this.buyCode = buyCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public int getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
    }
    
    // DjvBuyDetail 모델 복사
    public void CopyData(BuyDetailVO param)
    {
        this.buyDetailCode = param.getBuyDetailCode();
        this.buyCode = param.getBuyCode();
        this.menuCode = param.getMenuCode();
        this.buyQuantity = param.getBuyQuantity();
        this.buyPrice = param.getBuyPrice();
    }
}
