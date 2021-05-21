package com.spring.vo;

public class MemberVO {
	private String memberId;
	private String password;
	private String name;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
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
	@Override
	public String toString() {//확인위해 넣은것뿐임
		return "MemberVO [memberId=" + memberId + ", password=" + password + ", name=" + name + "]";
	}
	
	
	
	
}
