package com.spring.vo;

public class SampleVO2 {
	private String empno;
	private String eName;
	private String job;
	private String age;
	private String gender;
	private String tel;
	private String deptno;
	private String[] tels;
	private String dName;
	private String loc;
	
	
	
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String[] getTels() {
		return tels;
	}
	public void setTels(String[] tels) {
		this.tels = tels;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
	
	
	
	

}
