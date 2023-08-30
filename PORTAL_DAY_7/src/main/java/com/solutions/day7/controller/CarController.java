package com.solutions.day7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.day7.model.CarModel;
import com.solutions.day7.service.CarService;

@RestController
public class CarController {
		@Autowired
		CarService cs;
		
		@PostMapping("owner/{data}")
		public List<CarModel> getByOwn(@PathVariable int data){
			return cs.getByOwn(data);
		}
		
		@GetMapping("address/{address}")
		public List<CarModel> getByaddr(@PathVariable String address){
				return cs.getByAddr(address);
		}
		
		@GetMapping("carname/{carname}")
		public List<CarModel> getByName(@PathVariable String carname){
			return cs.getByName(carname);
		}
		
		@GetMapping("owners/{owners}/carType/{carType}")
		public List<CarModel> getByBoth(@PathVariable int owners, @PathVariable String cartype){
			return cs.getBoth(owners, cartype);
		}
		
		
}
