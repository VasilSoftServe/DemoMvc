/**
 * 
 */
package com.softserve.academy.dao;

import java.util.List;

import com.softserve.academy.model.Book;

/**
 * @author 123
 *
 */
public interface BookDao {

	public void add(Book book);
	
	public void edit(Book book);
	
	public void deleteBook(int bookId);
	
	public Book findById(int bookId);	
	
	public List<Book> findAllBooks();
	
}
