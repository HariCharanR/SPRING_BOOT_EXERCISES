package com.solutions.day5.Exercise.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solutions.day5.Exercise.Model.BookModel;
import com.solutions.day5.Exercise.Service.BookService;

@RestController
public class BookController {
		
	@Autowired
	BookService bs;
	
	@GetMapping("/")
	public List<BookModel> get_students(){
		return bs.fetchAllBooks();
	}
	
	@GetMapping("/{id}")
	public BookModel get_student (@PathVariable int id) {
		return bs.fetchBook(id);
	}
	
	@PostMapping("/")
	public BookModel post_student(@RequestBody BookModel book) {
		return bs.createBook(book);
	}
	
	
	@PutMapping("/{id}")
	public BookModel put_student(@RequestBody BookModel book ,@PathVariable int id ) {
		return bs.updateBook(new BookModel(id,book.getName(),book.getPrice(),book.getQuantity(),book.getAuthorName()));
	}
	
	@DeleteMapping("/{id}")
	public void delete_student(@PathVariable int id) {
		bs.deleteBook(id);
	}
	
	
}
