package com.javadevtool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javadevtool.entity.BookEntity;
import com.javadevtool.repository.BookRepo;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	
	//To get All books..(Isliye List)
	@Override
	public List<BookEntity> getAllBooks(){
		
		return bookRepo.findAll();
	}
	
	//To Get a Single Book by ID
	@Override
	public BookEntity bookById(int id) {
		
		BookEntity book= null;
		try {
			return bookRepo.findById(id);
			
		} catch (Exception e) {
			System.out.println("No book for the selected ID is found..");
		}
		return book;
	}
	
	//To add a book.
	@Override
	public BookEntity addBook(BookEntity b) {
		
		return bookRepo.save(b);
	}
	
	//To delete a book from the table(Yaha return statement nahi rahega as we r just deleting the things..
	@Override
	public void deleteBookbyId(int id) {
		 bookRepo.deleteById(id);
	}
	
	//To update a book by ID
	@Override
	public void updateBookById(BookEntity book, int id) {
		
		book.setId(id); 
		bookRepo.save(book);
	}
	
	 public void saveFileNames(MultipartFile[] files) {
	        List<String> fileNames = new ArrayList<>();

	        // Extract filenames from MultipartFiles
	        for (MultipartFile file : files) {
	            fileNames.add(file.getOriginalFilename());
	        }

	        // Save filenames to the database
	        String commaSeparatedFileNames = String.join(",", fileNames);
	        BookEntity bookEntity = new BookEntity();
	        bookEntity.setOriginalFileName(commaSeparatedFileNames);
	        bookRepo.save(bookEntity);
	    }

	
	
	
	
}

//-------------------------------------BookService.java Class (Now divided it into BookServiceImpl and BookService.class)-----------
//package com.javadevtool.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.javadevtool.entity.BookEntity;
//import com.javadevtool.repository.BookRepo;
//
//
//@Service
//public class BookService {
//
//	@Autowired
//	private BookRepo bookRepo;
//	
//	//To get all books..(Isliye List)
//	public List<BookEntity> getAllBook(){
//		
//		return bookRepo.findAll();
//	}
//	
//	//To get book by ID.
//	public BookEntity bookById(int id) {
//		
//		BookEntity book= null;
//		try {
//			return bookRepo.findById(id);
//			
//		} catch (Exception e) {
//			System.out.println("No book for the selected ID is found..");
//		}
//		return book;
//	}
//	
//	//To add a book.
//	public BookEntity addBook(BookEntity b) {
//		
//		return bookRepo.save(b);
//	}
//	
//	//To delete a book from the table(Yaha return statement nahi rahega as we r just deleting the things..
//	public void deleteBookbyId(int id) {
//		 bookRepo.deleteById(id);
//	}
//	
//	//To update a book by ID
//	public void updateBookById(BookEntity book, int id) {
//		
//		book.setId(id); 
//		bookRepo.save(book);
//	}
//	
//}
