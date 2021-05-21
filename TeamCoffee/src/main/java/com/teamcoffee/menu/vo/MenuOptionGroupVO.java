package com.teamcoffee.menu.vo;

public class MenuOptionGroupVO {
	
	// 옵션그룹 코드 
    private String menuOptionGroupCode;

    // 옵션그룹 이름 
    private String menuOptionGroupName;

    // 옵션그룹  타입 
    private String menuOptionGroupType;

    // 카페 코드 
    private String cafeCode;

	public String getMenuOptionGroupCode() {
        return menuOptionGroupCode;
    }

    public void setMenuOptionGroupCode(String menuOptionGroupCode) {
        this.menuOptionGroupCode = menuOptionGroupCode;
    }

    public String getMenuOptionGroupName() {
        return menuOptionGroupName;
    }

    public void setMenuOptionGroupName(String menuOptionGroupName) {
        this.menuOptionGroupName = menuOptionGroupName;
    }

    public String getMenuOptionGroupType() {
        return menuOptionGroupType;
    }

    public void setMenuOptionGroupType(String menuOptionGroupType) {
        this.menuOptionGroupType = menuOptionGroupType;
    }

    public String getCafeCode() {
        return cafeCode;
    }

    public void setCafeCode(String cafeCode) {
        this.cafeCode = cafeCode;
    }

    // DjvMenuOptionGroup 모델 복사
    public void CopyData(MenuOptionGroupVO param)
    {
        this.menuOptionGroupCode = param.getMenuOptionGroupCode();
        this.menuOptionGroupName = param.getMenuOptionGroupName();
        this.menuOptionGroupType = param.getMenuOptionGroupType();
        this.cafeCode = param.getCafeCode();
    }
	
}
