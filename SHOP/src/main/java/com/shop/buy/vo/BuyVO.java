package com.shop.buy.vo;

import java.sql.Date;

public class BuyVO {
	private String buyCode;
	private String itemCode;
	private int buyQuantity;
	private String buyer;
	private Date buyDate;
	
	//1. input태그의 name속성과 일치하는 변수를 vo에 만들고  setter,getter를 추가한다.
	//2. mybatis의 association혹은 collection을 사용한다.
	//3. view를 사용한다.
	
	
	
	
	public String getBuyCode() {
		return buyCode;
	}
	public void setBuyCode(String buyCode) {
		this.buyCode = buyCode;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public int getBuyQuantity() {
		return buyQuantity;
	}
	public void setBuyQuantity(int buyQuantity) {
		this.buyQuantity = buyQuantity;
	}
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public Date getBuyDate() {
		return buyDate;
	}
	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}
	
	
	
	
	
	
}
