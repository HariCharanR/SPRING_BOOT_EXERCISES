package com.solutions.day5.Exercise.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.solutions.day5.Exercise.Model.BookModel;

public interface BookRepo extends JpaRepository<BookModel,Integer>{
	
}
