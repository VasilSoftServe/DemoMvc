package com.softserve.academy.dao.author;

import java.util.List;

import com.softserve.academy.model.Author;


public interface AuthorDao {

	Author findById(Long id);

	void saveAuthor(Author author);

	void deleteAuthorById(Long id);

	List<Author> findAllAuthors();
}
