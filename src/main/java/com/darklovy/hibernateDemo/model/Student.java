package com.darklovy.hibernateDemo.model;

import java.util.Date;

public class Student {
	private int id;
	private String name;
	private String sex;
	private Date regDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public Student(String name, String sex, Date regDate) {
		super();
		this.name = name;
		this.sex = sex;
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", regDate=" + regDate + "]";
	}
	
	
	
}
