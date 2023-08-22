package com.solutions.day5.Exercise.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solutions.day5.Exercise.Model.BookModel;
import com.solutions.day5.Exercise.Repository.BookRepo;

@Service
public class BookService {
		
	@Autowired
	BookRepo book_db;
	
	public BookModel createBook(BookModel book) {
		return book_db.save(book);
	}
	
	public List<BookModel> fetchAllBooks(){
		return book_db.findAll();
	}
	
	public BookModel fetchBook(int id) {
		return book_db.findById(id).orElse(null);
	}
	public BookModel updateBook(BookModel book) {
		return book_db.save(book);
	}
	
	public void deleteBook(int id) {
		 book_db.deleteById(id);
	}
	
}
