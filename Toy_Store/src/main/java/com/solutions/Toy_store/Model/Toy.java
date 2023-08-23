package com.solutions.Toy_store.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
		
		
		
}
