package com.solutions.Toy_store.Model;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Toys")
public class Toy {
		@Id
		private int id;
		
		private String name;
		
		private int price;
		
		private String manufacturer;

		public Toy() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Toy(int id, String name, int price, String manufacturer) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.manufacturer = manufacturer;
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

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public String getManufacturer() {
			return manufacturer;
		}

		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}
		
		public String displayToy() {
			return "Toy Details:\nID:\t"+getId()+"\nName:\t"+getName()+"\nPrice:\t"+getPrice()+"\nManufacturer:\t"+getManufacturer()+"\n";
		}
		
		@ManyToOne
		@JoinColumn(name = "order_id")
		private Order order;

		public Toy(int id, String name, int price, String manufacturer, Order order) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.manufacturer = manufacturer;
			this.order = order;
		}

		public Integer getOrder() {
			if(order == null) return 0;
			return order.getId();
		}

		public void setOrder(Order order) {
			this.order = order;
		}
		 
		
		
}
