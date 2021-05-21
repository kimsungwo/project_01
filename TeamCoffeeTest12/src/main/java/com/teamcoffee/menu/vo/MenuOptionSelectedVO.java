package com.teamcoffee.menu.vo;

public class MenuOptionSelectedVO {
	 // 그룹 선택 코드 
    private String groupSelectedCode;

    // 메뉴 코드 
    private String menuCode;

    // 옵션그룹 코드 
    private String menuOptionGroupCode;

    public String getGroupSelectedCode() {
        return groupSelectedCode;
    }

    public void setGroupSelectedCode(String groupSelectedCode) {
        this.groupSelectedCode = groupSelectedCode;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuOptionGroupCode() {
        return menuOptionGroupCode;
    }

    public void setMenuOptionGroupCode(String menuOptionGroupCode) {
        this.menuOptionGroupCode = menuOptionGroupCode;
    }

    // DjvMenuGroupSelected 모델 복사
    public void CopyData(MenuOptionSelectedVO param)
    {
        this.groupSelectedCode = param.getGroupSelectedCode();
        this.menuCode = param.getMenuCode();
        this.menuOptionGroupCode = param.getMenuOptionGroupCode();
    }
	
	
}
