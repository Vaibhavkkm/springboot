package com.javadevtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javadevtool.entity.BookEntity;

public interface BookRepo extends JpaRepository<BookEntity, Integer>{
public BookEntity findById(int id);
}
