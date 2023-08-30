package com.solutions.Toy_store.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.solutions.Toy_store.Model.Customer;
import com.solutions.Toy_store.Repository.CustomerRepo;

@Service
public class CustomerService {
			
	@Autowired
	CustomerRepo c;
	
	public Customer createCustomer(Customer cust) {
		if(c.existsById(cust.getId())) {
			return null;
		}
		return c.save(cust);
	}
	
	public List<Customer> fetchAllCustomer(){
		return c.findAll(Sort.by(Sort.Direction.ASC,"name"));
	}
//	public List<Customer> fetchByMname(String name){
////		return c.findrecordByMname(name);
//	}
	
	public Customer fetchCustomer(int id) {
		return c.findById(id).orElse(null);
	}
	public Customer updateCustomer(Customer cust) {
		if(c.existsById(cust.getId())) {
			return c.save(cust);				
		}
		return null;
	}
	
	public List<Customer> fetch_by_batch(int pno, int psize){
		PageRequest page = PageRequest.of(pno, psize,Sort.by(Sort.Direction.ASC,"name"));
		return c.findAll(page).getContent();
	}
	public boolean deleteCustomer(int id) {
		if(c.existsById(id)) {
			c.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
