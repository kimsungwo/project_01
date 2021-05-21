package com.teamcoffee.cart.vo;

import java.util.List;

public class CartOptionVO {
	 // 장바구니 옵션 코드 
    private String cartOptionCode;

    // 장바구니 코드 
    private String cartCode;

    // 옵션 코드 
    private String menuOptionCode;
    
    private List<String> requiredOptions;
    
    private List<String> selectionOptions;
    
    private List<CartOptionVO> cartOptions;
    
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

    public List<CartOptionVO> getCartOptions() {
		return cartOptions;
	}

	public void setCartOptions(List<CartOptionVO> cartOptions) {
		this.cartOptions = cartOptions;
	}

	public String getCartOptionCode() {
        return cartOptionCode;
    }

    public void setCartOptionCode(String cartOptionCode) {
        this.cartOptionCode = cartOptionCode;
    }

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    public String getMenuOptionCode() {
        return menuOptionCode;
    }

    public void setMenuOptionCode(String menuOptionCode) {
        this.menuOptionCode = menuOptionCode;
    }

    // DjvCartOption 모델 복사
    public void CopyData(CartOptionVO param)
    {
        this.cartOptionCode = param.getCartOptionCode();
        this.cartCode = param.getCartCode();
        this.menuOptionCode = param.getMenuOptionCode();
    }
}
