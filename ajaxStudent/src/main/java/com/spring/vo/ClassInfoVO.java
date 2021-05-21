package com.spring.vo;

public class ClassInfoVO {
	private String classCode;
	private String className;
	public String getClassCode() {
		return classCode;
	}
	public void setClassCode(String classCode) {
		this.classCode = classCode;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "ClassInfoVO [classCode=" + classCode + ", className=" + className + "]";
	}
	
	
	
}
