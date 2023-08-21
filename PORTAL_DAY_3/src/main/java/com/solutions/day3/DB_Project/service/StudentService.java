package com.solutions.day3.DB_Project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.day3.DB_Project.model.Employee;
import com.solutions.day3.DB_Project.repository.StudentRecord;

@Service
public class StudentService {
	
	@Autowired
	StudentRecord s;
	
	
	public Employee createEmployee(Employee stud) {
		return s.save(stud);
	}
	
	public List<Employee> getEmployees(){
		return s.findAll();
	}
	
	
	
}
