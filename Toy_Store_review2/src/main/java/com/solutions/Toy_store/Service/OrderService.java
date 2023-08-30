package com.solutions.Toy_store.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.solutions.Toy_store.Model.Order;
import com.solutions.Toy_store.Repository.OrderRepo;

@Service
public class OrderService {
		
	@Autowired
	OrderRepo o;
	
	public Order createOrder(Order order) {
		if(o.existsById(order.getId())) {
			return null;
		}
		return o.save(order);
	}
	
	public List<Order> fetchAllOrders(){
		return o.findAll(Sort.by(Sort.Direction.ASC,"amount"));
	}
//	public List<Order> fetchByMname(){
//		return t.findrecordByMname(name);
//	}
	
	public Order fetchOrder(int id) {
		return o.findById(id).orElse(null);
	}
	public Order updateOrder(Order order) {
		if(o.existsById(order.getId())) {
			return o.save(order);				
		}
		return null;
	}
	
	public List<Order> fetch_by_batch(int pno, int psize){
		PageRequest page = PageRequest.of(pno, psize,Sort.by(Sort.Direction.ASC,"amount"));
		return o.findAll(page).getContent();
	}
	public boolean deleteOrder(int id) {
		if(o.existsById(id)) {
			o.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
