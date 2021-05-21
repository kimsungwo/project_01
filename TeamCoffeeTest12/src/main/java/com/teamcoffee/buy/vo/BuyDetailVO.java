package com.teamcoffee.buy.vo;

import java.util.List;

public class BuyDetailVO {
	// 구매 상세 코드 
    private String buyDetailCode;

    // 구매 코드 
    private String buyCode;

    // 메뉴 코드 
    private String menuCode;

    // 구매량 
    private int buyQuantity;
    
    private int totalPrice;
    
    private String cafeCode;

    private List<String> requiredOptions;
    
    private List<String> selectionOptions;

	public List<String> getRequiredOptions() {
		return requiredOptions;
	}

	public void setRequiredOptions(List<String> requiredOptions) {
		this.requiredOptions = requiredOptions;
	}

	public List<String> getSelectionOptions() {
		return selectionOptions;
	}

	public void setSelectionOptions(List<String> selectionOptions) {
		this.selectionOptions = selectionOptions;
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

    // DjvBuyDetail 모델 복사
    public void CopyData(BuyDetailVO param)
    {
        this.buyDetailCode = param.getBuyDetailCode();
        this.buyCode = param.getBuyCode();
        this.menuCode = param.getMenuCode();
        this.buyQuantity = param.getBuyQuantity();
    }
}
