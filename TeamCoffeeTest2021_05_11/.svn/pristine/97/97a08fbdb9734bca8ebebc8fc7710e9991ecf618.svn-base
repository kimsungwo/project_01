package com.teamcoffee.buy.vo;

import java.util.List;

public class BuyDetailOptionVO {
	 // 구매 상세 옵션 코드 
    private String buyDetailOptionCode;

    // 구매 상세 코드 
    private String buyDetailCode;

    // 옵션 그룹 코드 
    private String menuOptionGroupCode;

    // 옵션 코드 
    private String menuOptionCode;

    private List<String> requiredOptionGroup;
    
    private List<String> selectionOptionGroup;
    
    public List<String> getRequiredOptionGroup() {
		return requiredOptionGroup;
	}

	public void setRequiredOptionGroup(List<String> requiredOptionGroup) {
		this.requiredOptionGroup = requiredOptionGroup;
	}

	public List<String> getSelectionOptionGroup() {
		return selectionOptionGroup;
	}

	public void setSelectionOptionGroup(List<String> selectionOptionGroup) {
		this.selectionOptionGroup = selectionOptionGroup;
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

    public String getMenuOptionGroupCode() {
        return menuOptionGroupCode;
    }

    public void setMenuOptionGroupCode(String menuOptionGroupCode) {
        this.menuOptionGroupCode = menuOptionGroupCode;
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
        this.menuOptionGroupCode = param.getMenuOptionGroupCode();
        this.menuOptionCode = param.getMenuOptionCode();
    }
}
