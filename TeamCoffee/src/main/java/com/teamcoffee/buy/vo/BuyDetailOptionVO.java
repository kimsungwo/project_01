package com.teamcoffee.buy.vo;

import java.util.List;

public class BuyDetailOptionVO {
	 // 구매 상세 옵션 코드 
    private String buyDetailOptionCode;

    // 구매 상세 코드 
    private String buyDetailCode;

    // 옵션 코드 
    private String menuOptionCode;

    private List<BuyDetailOptionVO> buyDetailOptions;
    
	public List<BuyDetailOptionVO> getBuyDetailOptions() {
		return buyDetailOptions;
	}

	public void setBuyDetailOptions(List<BuyDetailOptionVO> buyDetailOptions) {
		this.buyDetailOptions = buyDetailOptions;
	}

	public String getBuyDetailOptionCode() {
        return buyDetailOptionCode;
    }

    public void setBuyDetailOptionCode(String buyDetailOptionCode) {
        this.buyDetailOptionCode = buyDetailOptionCode;
    }

    public String getBuyDetailCode() {
        return buyDetailCode;
    }

    public void setBuyDetailCode(String buyDetailCode) {
        this.buyDetailCode = buyDetailCode;
    }

    public String getMenuOptionCode() {
        return menuOptionCode;
    }

    public void setMenuOptionCode(String menuOptionCode) {
        this.menuOptionCode = menuOptionCode;
    }

    // DjvBuyDetailOption 모델 복사
    public void CopyData(BuyDetailOptionVO param)
    {
        this.buyDetailOptionCode = param.getBuyDetailOptionCode();
        this.buyDetailCode = param.getBuyDetailCode();
        this.menuOptionCode = param.getMenuOptionCode();
    }

	@Override
	public String toString() {
		return "BuyDetailOptionVO [buyDetailOptionCode=" + buyDetailOptionCode + ", buyDetailCode=" + buyDetailCode
				+ ", menuOptionCode=" + menuOptionCode + ", buyDetailOptions=" + buyDetailOptions + "]";
	}
    
    
    
}
