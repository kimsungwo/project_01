package com.teamcoffee.menu.vo;

public class MenuImgVO {
    // 이미지 코드 
    private String menuImgCode;

    // 이미지 이름 
    private String menuImgName;

    // 메뉴 코드 
    private String menuCode;

    public String getMenuImgCode() {
        return menuImgCode;
    }

    public void setMenuImgCode(String menuImgCode) {
        this.menuImgCode = menuImgCode;
    }

    public String getMenuImgName() {
        return menuImgName;
    }

    public void setMenuImgName(String menuImgName) {
        this.menuImgName = menuImgName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    // DjvMenuImg 모델 복사
    public void CopyData(MenuImgVO param)
    {
        this.menuImgCode = param.getMenuImgCode();
        this.menuImgName = param.getMenuImgName();
        this.menuCode = param.getMenuCode();
    }
}
