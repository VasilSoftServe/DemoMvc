package com.softserve.academy.service;

import java.util.List;

import com.softserve.academy.model.Book;

public interface BookService {

	Book findById(long id);
	
	void saveBook(Book book);
	
	void updateBook(Book book);
	
	void deleteBookById(long id);
	
	List<Book> findAllBooks();
}
