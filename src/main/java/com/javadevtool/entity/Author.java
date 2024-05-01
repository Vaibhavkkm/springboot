package com.javadevtool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity


public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String book_info;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBook_info() {
		return book_info;
	}
	public void setBook_info(String book_info) {
		this.book_info = book_info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Author(int id, String book_info, String name) {
		super();
		this.id = id;
		this.book_info = book_info;
		this.name = name;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
