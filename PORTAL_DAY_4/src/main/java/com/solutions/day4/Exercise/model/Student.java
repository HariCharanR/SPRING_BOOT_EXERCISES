package com.solutions.day4.Exercise.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students1")
public class Student {
	
	@Id
	private int Reg_no;
	
	private String name;
	private String dept;
	private String mail;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int reg_no, String name, String dept, String mail) {
		super();
		Reg_no = reg_no;
		this.name = name;
		this.dept = dept;
		this.mail = mail;
	}
	public int getReg_no() {
		return Reg_no;
	}
	public void setReg_no(int reg_no) {
		Reg_no = reg_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	
}
