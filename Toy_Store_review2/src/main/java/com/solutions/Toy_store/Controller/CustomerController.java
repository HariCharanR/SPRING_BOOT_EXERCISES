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

import com.solutions.Toy_store.Model.Customer;
import com.solutions.Toy_store.Service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
		@Autowired
		CustomerService cs;
		
		@GetMapping("/")
		public List<Customer> get_customers(){
			return cs.fetchAllCustomer();
		}
		
		@GetMapping("/{pno}/{psize}")
		public List<Customer> get_customer_batch(@PathVariable int pno, @PathVariable int psize){
			return cs.fetch_by_batch(pno, psize);
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<String> get_customer(@PathVariable int id){
			
			Customer c = cs.fetchCustomer(id);
			
			if(c!=null) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(c.display());
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Find Customer of Specified Id");
			}
		}
		
		@PostMapping("/")
		public ResponseEntity<String> post_customer(@RequestBody Customer customer){
				Customer c = cs.createCustomer(customer);
				if(c != null) {
					return ResponseEntity.ok("The New Customer has been Added");
				}else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A Customer with the given Id already Exists ");
				}
		}
		@PutMapping("/{id}")
		public ResponseEntity<String> put_Customer(@RequestBody Customer customer , @PathVariable int id) {
			Customer c =  cs.updateCustomer(new Customer(id, customer.getName(),customer.getPhone()));
			if(c != null) {
				return ResponseEntity.ok("The Corresponding Customer has been Updated");
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Find Customer of Specified Id");
			}
		}
		@DeleteMapping("/{id}")
		public ResponseEntity<String> delete_Toy(@PathVariable int id) {
			 boolean status = cs.deleteCustomer(id);
			 if(status == true) {
				 return ResponseEntity.ok("The Corresponding Customer has been Deleted");
			 }else {
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Find Customer of Specified Id");
			 }
		}
		
}
