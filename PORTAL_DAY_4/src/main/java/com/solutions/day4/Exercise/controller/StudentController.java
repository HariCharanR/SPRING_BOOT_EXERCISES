package com.solutions.day4.Exercise.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.solutions.day4.Exercise.model.Student;
import com.solutions.day4.Exercise.service.StudentService;

@RestController
@RequestMapping("/")
public class StudentController {
		
	@Autowired
	StudentService ss;
	
	@GetMapping("/")
	public List<Student> get_students(){
		return ss.fetchAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student get_student(@PathVariable int id) {
		return ss.fetchStudent(id);
	}
	
	@PostMapping("/")
	public Student post_student(@RequestBody Student stud) {
		return ss.createStudent(stud);
	}
	
	@PutMapping("/{id}")
	public Student put_student(@RequestBody Student stud , @PathVariable int id) {
		return ss.updateStudent(new Student(id,stud.getName(),stud.getDept(),stud.getMail()));
	}
	
	@DeleteMapping("/{id}")
	public String delete_student(@PathVariable int id) {
		ss.deleteStudent(id);
		return "Student is successfully deleted";
	}
}
