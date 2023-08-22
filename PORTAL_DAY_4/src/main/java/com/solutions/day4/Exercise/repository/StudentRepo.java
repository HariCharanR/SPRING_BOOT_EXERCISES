package com.solutions.day4.Exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.day4.Exercise.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
