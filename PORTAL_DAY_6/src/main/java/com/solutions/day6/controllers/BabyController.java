package com.solutions.day6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.day6.model.BabyModel;
import com.solutions.day6.service.BabyService;

@RestController
public class BabyController {
		@Autowired
		BabyService bs ;
		
		@PostMapping("/")
		public BabyModel post_baby(@RequestBody BabyModel s) {
			return bs.createBaby(s);
		}
		
		@GetMapping("/")
		public List<BabyModel> get_Babies(){
			return bs.fetchAllBabies();
		}
		
		
		@GetMapping("/{name}")
		public List<BabyModel> get_baby_sorted(@PathVariable String name){
			return bs.fetchBabyInSorted(name);
		}
		
		@GetMapping("{pno}/{psize}")
		public List<BabyModel> get_baby_batch(@PathVariable int pno , @PathVariable int psize){
			return bs.fetchByBatch(pno, psize);
		}
		
		@DeleteMapping("/{id}")
		public void delete(@PathVariable int id) {
			bs.deleteBaby(id);
		}
		
		@GetMapping("/{name}/{pno}/{psize}")
		public List<BabyModel> get_baby_sortedBatch(@PathVariable String name, @PathVariable int pno , @PathVariable int psize){
			return bs.fetchByBatchSorted(name, pno, psize);
		}
		
		
		
}
