/**
 * 
 */
package com.softserve.academy.dao.book;

import java.util.List;

import com.softserve.academy.model.Book;

/**
 * @author 123
 *
 */
public interface BookDao {

	Book findById(Long id);

	void saveBook(Book book);

	void deleteBookById(Long id);

	List<Book> findAllBooks();
	
}
