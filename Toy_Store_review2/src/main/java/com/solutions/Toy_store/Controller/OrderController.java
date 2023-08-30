package com.solutions.Toy_store.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.Toy_store.Model.Order;
import com.solutions.Toy_store.Service.OrderService;

@RestController
@RequestMapping("/Orders")
public class OrderController {
		@Autowired
		OrderService os;
		
		@GetMapping("/")
		public List<Order> get_orders(){
			return os.fetchAllOrders();
		}
		
		@GetMapping("/{pno}/{psize}")
		public List<Order> get_order_batch(@PathVariable int pno , @PathVariable int psize){
			return os.fetch_by_batch(pno, psize);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<String> get_order(@PathVariable int id){
			 Order o = os.fetchOrder(id);
			 
			 if(o!=null) {
				 return ResponseEntity.status(HttpStatus.ACCEPTED).body(o.display());
			 }else {
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find Order of Specified Id");
			 }
		}
		
		@PostMapping("/")
		public ResponseEntity<String> post_order(@RequestBody Order order){
			Order o = os.createOrder(order);
			if(o!=null) {
				return ResponseEntity.ok("The new Order has been Placed");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The Order Already Exists and cannot be Placed");
			}
		}
		
		
		@PutMapping("/{id}")
		public ResponseEntity<String> put_order(@RequestBody Order order  , @PathVariable int id){
			Order o = os.updateOrder(new Order(id ,order.getAmount(),order.getToys()));
			if(o != null) {
				return ResponseEntity.ok("The Corresponding Order has been Updated");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Find Order of Specified Id");
			}
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<String> delete_toy(@PathVariable int id){
			boolean status = os.deleteOrder(id);
			
			if(status == true) {
				return ResponseEntity.ok("The Corresponding order is deleted");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Find order of Specified id");
			}
		}
}
