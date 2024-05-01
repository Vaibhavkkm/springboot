package com.javadevtool.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.javadevtool.entity.BookEntity;

public interface BookService {

	 List<BookEntity> getAllBooks();
	 BookEntity bookById(int id);
	 BookEntity addBook(BookEntity b);
	 void deleteBookbyId(int id);
	 void updateBookById(BookEntity book, int id);
	 public void saveFileNames(MultipartFile[] files);
	 
}
