package com.shop.member.vo;

public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String addr;
	private String addrDetail;
	private String email;
	private String gender;
	private String isAdmin;
	private String tel;
	private String regDate;
	private String[] tels;
	private String[] emails;
	
	public String[] getTels() {
		return tels;
	}
	public void setTels(String[] tels) {
		this.tels = tels;
	}
	public String[] getEmails() {
		return emails;
	}
	public void setEmails(String[] emails) {
		this.emails = emails;
	}
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAddrDetail() {
		return addrDetail;
	}
	public void setAddrDetail(String addrDetail) {
		this.addrDetail = addrDetail;
	}
	public String getEmail() {
		return emails[0]+"@"+emails[1];
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getTel() {
		if(tel == null) {
			return tels[0]+"-"+tels[1]+"-"+tels[2];			
		}
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	
}
