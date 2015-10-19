package com.softserve.academy.service;

import java.util.List;

import com.softserve.academy.model.Author;

public interface AuthorService {

	Author findById(long id);
	
	void saveAuthor(Author author);
	
	void updateAuthor(Author author);
	
	void deleteAuthorById(long id);
	
	List<Author> findAllAuthors();
}
