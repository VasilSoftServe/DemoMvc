/**
 *BookDao.java
 *
 *created at Oct 27, 2015 
 * 
 *@author Vasil Sokolov <vasilsokolov@abv.bg>
 *
 * Copyright (c) 2015 . All Rights Reserved.
 */
package com.softserve.academy.dao.book;

import java.util.Set;

import com.softserve.academy.model.Book;

public interface BookDao {

	Book findById(Long id);

	void saveBook(Book book);

	void deleteBookById(Long id);

	Set<Book> findAllBooks();
	
}
