package com.solutions.day3.Day3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Employees")
public class Employee {
	@Id 
	private int id;
	
	private String e_name;
	
	private int e_age;
	
	private long e_salary;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String e_name, int e_age, long e_salary) {
		super();
		this.id = id;
		this.e_name = e_name;
		this.e_age = e_age;
		this.e_salary = e_salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}

	public int getE_age() {
		return e_age;
	}

	public void setE_age(int e_age) {
		this.e_age = e_age;
	}

	public long getE_salary() {
		return e_salary;
	}

	public void setE_salary(long e_salary) {
		this.e_salary = e_salary;
	}
	
	
	
}
