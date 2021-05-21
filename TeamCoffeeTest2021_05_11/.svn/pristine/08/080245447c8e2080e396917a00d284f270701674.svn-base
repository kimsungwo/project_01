package com.teamcoffee.cart.vo;

public class CartVO {
	// 장바구니 코드 
    private String cartCode;

    // 메뉴 코드 
    private String menuCode;

    // 구매량 
    private int buyQuantity;

    // 회원코드
    private String memCode;
    
    // 개별 가격
    private int cartPrice;
    
    
    public int getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(int cartPrice) {
		this.cartPrice = cartPrice;
	}

	public String getMemCode() {
		return memCode;
	}

	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}

	public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
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

    // DjvCart 모델 복사
    public void CopyData(CartVO param)
    {
        this.cartCode = param.getCartCode();
        this.menuCode = param.getMenuCode();
        this.buyQuantity = param.getBuyQuantity();
        this.memCode = param.getMemCode();
        this.cartPrice = param.getCartPrice();
    }
}
