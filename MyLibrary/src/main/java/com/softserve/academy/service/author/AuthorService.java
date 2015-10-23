package com.softserve.academy.service.author;

import java.util.List;

import com.softserve.academy.model.Author;

public interface AuthorService {

	Author findById(long id);
	
	void saveAuthor(Author author);
	
	void updateAuthor(Author author);
	
	void deleteAuthor(Author author);
	
	List<Author> findAllAuthors();
}
