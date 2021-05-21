package com.spring.vo;

public class StudentVO {
	private String stuNum;
	private String stuName;
	private int stuAge;
	private String stuAddr;
	private int korScore;
	private int engScore;
	private int mathScore;
	private String classCode;
	
	private ClassInfoVO classVO;

//	private String classCode;
	
	
	
//	public String getClassCode() {
//		return classCode;
//	}
//
//	public void setClassCode(String classCode) {
//		this.classCode = classCode;
//	}

	public ClassInfoVO getClassVO() {
		return classVO;
	}

	public String getClassCode() {
		return classCode;
	}

	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}

	public void setClassVO(ClassInfoVO classVO) {
		this.classVO = classVO;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getStuAge() {
		return stuAge;
	}

	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}

	public String getStuAddr() {
		return stuAddr;
	}

	public void setStuAddr(String stuAddr) {
		this.stuAddr = stuAddr;
	}

	public int getKorScore() {
		return korScore;
	}

	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}

	public int getEngScore() {
		return engScore;
	}

	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}

	public int getMathScore() {
		return mathScore;
	}

	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}

	@Override
	public String toString() {
		return "StudentVO [stuNum=" + stuNum + ", stuName=" + stuName + ", stuAge=" + stuAge + ", stuAddr=" + stuAddr
				+ ", korScore=" + korScore + ", engScore=" + engScore + ", mathScore=" + mathScore + ", classVO="
				+ classVO + "]";
	}


	
	
	

}
