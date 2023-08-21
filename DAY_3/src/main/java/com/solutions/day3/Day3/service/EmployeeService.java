package com.solutions.day3.Day3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.day3.Day3.model.Employee;
import com.solutions.day3.Day3.repository.EmployeeRecord;



@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRecord s;
	
	
	public Employee createEmployee(Employee stud) {
		return s.save(stud);
	}
	
	public List<Employee> getEmployees(){
		return s.findAll();
	}
	
	
	
}
