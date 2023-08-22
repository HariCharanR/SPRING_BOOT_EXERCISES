package com.solutions.day4.Exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.day4.Exercise.model.Student;
import com.solutions.day4.Exercise.repository.StudentRepo;

@Service
public class StudentService {
		
	@Autowired
	StudentRepo s;
	
	public Student createStudent(Student stud) {
		return s.save(stud);
	}
	
	public List<Student> fetchAllStudents(){
		return s.findAll();
	}
	public Student fetchStudent(int id) {
		return  s.findById(id).orElse(null);
	}
	
	public Student updateStudent(Student stud) {
		return s.saveAndFlush(stud);
	}
	
	public void deleteStudent(int id) {
		 s.deleteById(id);
	}
	
	
}
