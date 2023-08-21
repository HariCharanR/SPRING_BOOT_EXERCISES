package com.solutions.day3.Day3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.solutions.day3.Day3.model.Employee;
public interface EmployeeRecord extends JpaRepository<Employee,Integer> {
	
}
