package com.javadevtool.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javadevtool.entity.BookEntity;
import com.javadevtool.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	
	//To get All the books
	@GetMapping("/getAllBooks")
	public ResponseEntity<List<BookEntity>> getAllBooks(){
		
		//List of Book in return(Ye(List) isliye lagaya coz hume SAB books chahiye so..)
		List<BookEntity> listOfBooks = bookService.getAllBooks();
		if(listOfBooks.size() <=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(listOfBooks);

	}
	//To Get a Single Book by ID
	@GetMapping("/getBook/{id}")
	public ResponseEntity<BookEntity> getBookById(@PathVariable("id") int id){
		
		BookEntity book = bookService.bookById(id);
		
		
		if(book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(book);
	}
	
	//To add a new book
	@PostMapping("/addBook")
	public ResponseEntity<BookEntity> addBooks(@RequestBody BookEntity book){
		BookEntity b = null;
		
		try {
			b= this.bookService.addBook(book);
			System.out.println("Book: "+  book + "has been added");
			return ResponseEntity.status(HttpStatus.CREATED).build();			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}

	//To delete a book
			@DeleteMapping("/deleteBook/{id}")
			public ResponseEntity<Void> deleteBook(@PathVariable("id") int id){
				
			try {
				
				this.bookService.deleteBookbyId(id);
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
				
				
			}
			
	//To update a book
			@PutMapping("/updateBook/{id}")
			public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity book,@PathVariable("id") int id){
				
				try {
					this.bookService.updateBookById(book, id);
					return ResponseEntity.status(HttpStatus.CREATED).build();
					
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}
				
			}

			
}
