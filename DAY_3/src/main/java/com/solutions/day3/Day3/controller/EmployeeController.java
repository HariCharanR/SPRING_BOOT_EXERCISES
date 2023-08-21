package com.solutions.day3.Day3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.day3.Day3.model.Employee;
import com.solutions.day3.Day3.service.EmployeeService;



@RestController
//@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	EmployeeService s;
	
	@PostMapping("/new_employee")
	public Employee post_employee(@RequestBody Employee emp ) {
	
		return s.createEmployee(emp);
	}
	
	@GetMapping("/Employees")
	public List<Employee> get_employee(){
		return s.getEmployees();
	}
}
