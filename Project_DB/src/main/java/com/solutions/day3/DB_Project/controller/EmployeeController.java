package com.solutions.day3.DB_Project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.day3.DB_Project.model.Employee;
import com.solutions.day3.DB_Project.service.StudentService;

@RestController
//@RequestMapping("/")
public class EmployeeController {
	
	@Autowired
	StudentService s;
	
	@PostMapping("/new_employee")
	public Employee post_employee(@RequestBody Employee emp ) {
	
		return s.createEmployee(emp);
	}
	
	@GetMapping("/Employees")
	public List<Employee> get_employee(){
		return s.getEmployees();
	}
	
	
	
}
