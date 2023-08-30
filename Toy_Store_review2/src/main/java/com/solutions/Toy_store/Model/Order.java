package com.solutions.Toy_store.Model;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	private int id;
	
	private int amount;
	
	@ManyToOne
	@JoinColumn( name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order" , cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Toy> toys = new ArrayList<>();



	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int id, int amount, Customer customer,List<Toy> toys) {
		super();
		this.id = id;
		this.amount = amount;
		this.customer = customer;
		this.toys = toys;
	}
	public Order(int id, int amount,List<Toy> toys) {
		super();
		this.id = id;
		this.amount = amount;
		this.toys = toys;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCustomerr() {
		return customer.getName();
	}

	public void setCustomerr(Customer customer) {
		this.customer = customer;
	}

	public List<Toy> getToys() {
		return toys;
	}

	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}
	
	
	public String display() {
		return "Order Details:\nID:\t"+getId()+"\nAmount:\t"+getAmount()+"\nOrdered By:\t"+getCustomerr();
	}

	
	
	
}
