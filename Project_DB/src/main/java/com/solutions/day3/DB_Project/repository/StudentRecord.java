package com.solutions.day3.DB_Project.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.solutions.day3.DB_Project.model.Employee;

public interface StudentRecord extends JpaRepository<Employee,Integer> {
	
}
