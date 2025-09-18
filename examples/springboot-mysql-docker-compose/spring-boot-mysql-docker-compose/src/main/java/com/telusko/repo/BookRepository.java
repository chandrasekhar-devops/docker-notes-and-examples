package com.telusko.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.telusko.model.Book;

public interface BookRepository extends JpaRepository<Book, Serializable> {

}