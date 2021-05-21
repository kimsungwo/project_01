package com.shop.item.vo;

import java.util.List;

public class ItemViewVO {
	private String itemCode;
	private String itemName;
	private String categoryCode;
	private String categoryName;
	private String createUser;
	private String createDate;
	private String itemInfo;
	private int itemPrice;
	private int itemStock;
	private int itemStatus;
	private String imgCode;
	private String imgName;
	private String isMain;
	private String order;
	private String sort;
	
	/* private int[] itemStatuses; */
	private List<Integer> itemStatuses;
	
	
	
	
	public List<Integer> getItemStatuses() {
		return itemStatuses;
	}
	public void setItemStatuses(List<Integer> itemStatuses) {
		this.itemStatuses = itemStatuses;
	}
	/*
	 * public int[] getItemStatuses() { return itemStatuses; } public void
	 * setItemStatuses(int[] itemStatuses) { this.itemStatuses = itemStatuses; }
	 */
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getImgCode() {
		return imgCode;
	}
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getIsMain() {
		return isMain;
	}
	public void setIsMain(String isMain) {
		this.isMain = isMain;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getItemInfo() {
		return itemInfo;
	}
	public void setItemInfo(String itemInfo) {
		this.itemInfo = itemInfo;
	}


	public int getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemStock() {
		return itemStock;
	}
	public void setItemStock(int itemStock) {
		this.itemStock = itemStock;
	}
	@Override
	public String toString() {
		return "ItemViewVO [itemCode=" + itemCode + ", itemName=" + itemName 
				+ ", categoryCode=" + categoryCode
				+ ", categoryName=" + categoryName 
				+ ", createUser=" + createUser 
				+ ", createDate=" + createDate
				+ ", itemInfo=" + itemInfo 
				+ ", itemPrice=" + itemPrice 
				+ ", itemStock=" + itemStock 
				+ ", itemStatus="+ itemStatus 
				+ ", imgCode=" + imgCode 
				+ ", imgName=" + imgName 
				+ ", isMain=" + isMain
				+ ", order="+ order 
				+ ", sort=" + sort + "]";
	}

	
	
	
}
