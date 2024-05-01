package com.javadevtool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="Book")
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "id")
	private int id;
	
	@Column(name= "name_of_Book")
	private String nameOfBook;
	
	@Column(name= "original_file_name")
	private String originalFileName;
	
	
	
	
public BookEntity(String originalFileName) {
		super();
		this.originalFileName = originalFileName;
	}
public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	//	@OneToOne(cascade = CascadeType.ALL)
	@Column(name= "author")
	private String author;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameOfBook() {
		return nameOfBook;
	}
	public void setNameOfBook(String nameOfBook) {
		this.nameOfBook = nameOfBook;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BookEntity(int id, String nameOfBook, String author) {
		super();
		this.id = id;
		this.nameOfBook = nameOfBook;
		this.author = author;
	}
	public BookEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", nameOfBook=" + nameOfBook + ", author=" + author + "]";
	}
	
	
	
	
	
}
