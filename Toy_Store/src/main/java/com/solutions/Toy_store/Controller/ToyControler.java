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
import org.springframework.web.bind.annotation.RestController;

import com.solutions.Toy_store.Model.Toy;
import com.solutions.Toy_store.Service.ToyService;

@RestController
public class ToyControler {
		
	@Autowired
	ToyService ts;
	
	@GetMapping("/")
	public List<Toy> get_Toys(){
		return ts.fetchAllToy();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> get_Toy(@PathVariable int id) {
		Toy t =  ts.fetchToy(id);
		
		if(t != null) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(t.toString());
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Find Toy of Specified Id");
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<String> post_Toy (@RequestBody Toy toy) {
		
		
		Toy t =  ts.createToy(toy);
		
		if(t != null) {
			return ResponseEntity.ok("The New Toy has been Added");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A Toy with the given Id already Exists ");
		}
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> put_Toy(@RequestBody Toy toy , @PathVariable int id) {
		Toy t =  ts.updateToy(new Toy(id, toy.getName(),toy.getPrice() , toy.getManufacturer()));
		if(t != null) {
			return ResponseEntity.ok("The Corresponding Toy has been Updated");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Find Toy of Specified Id");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete_Toy(@PathVariable int id) {
		 boolean status = ts.deleteToy(id);
		 if(status == true) {
			 return ResponseEntity.ok("The Corresponding Toy has been Deleted");
		 }else {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot Find Toy of Specified Id");
		 }
	}
}
