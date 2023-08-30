package com.solutions.Toy_store.Model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
		@Id
		private int id;
		
		private String name;
		
		private long phone;
	
		
		@OneToMany(mappedBy="customer" ,cascade=CascadeType.ALL , orphanRemoval = true)
		private List<Order> orders = new ArrayList<>();

		public Customer(int id, String name, long phone, List<Order> orders) {
			super();
			this.id = id;
			this.name = name;
			this.phone = phone;
			this.orders = orders;
		}
		
		
		
		

		public Customer(int id, String name, long phone) {
			super();
			this.id = id;
			this.name = name;
			this.phone = phone;
		}





		public List<Order> getOrders() {
			return orders;
		}
		public void setOrders(List<Order> orders) {
			this.orders = orders;
		}
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

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
		public String display() {
			return "Customer Details:\nID:\t"+getId()+"\nName:\t"+getName()+"\nPhone No:\t"+getPhone()+"\norders:"+getOrders();
		}
		
		
		
}
