package com.softserve.academy.service;

import java.util.List;

import com.softserve.academy.model.Book;

public interface BookService {

	Book findById(int bookId);
	
	void addBook(Book book);
	
	void editBook(Book book);
	
	void deleteBookById(int bookId);
	
	List<Book> findAllBook();
}
