package com.solutions.day6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Parent_details")
public class BabyModel {
		
	@Id
	private int id;
	
	private String fname,lname,father,mother,address;

	public BabyModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BabyModel(int id, String fname, String lname, String father, String mother, String address) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.father = father;
		this.mother = mother;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getMother() {
		return mother;
	}

	public void setMother(String mother) {
		this.mother = mother;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
