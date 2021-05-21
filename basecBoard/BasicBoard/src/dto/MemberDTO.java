package dto;

public class MemberDTO {
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
	public String toString() {
		return "MemberDTO [memberId=" + memberId + ", password=" + password + ", name=" + name + "]";
	}
	
	
	
}
