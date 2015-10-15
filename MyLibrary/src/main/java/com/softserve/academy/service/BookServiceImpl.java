/**
 * 
 */
package com.softserve.academy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.softserve.academy.dao.BookDao;
import com.softserve.academy.model.Book;

/**
 * @author 123
 *
 */
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softserve.academy.service.BookService#findById(int)
	 */
	@Override
	public Book findById(int bookId) {
		return bookDao.findById(bookId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.softserve.academy.service.BookService#addBook(com.softserve.academy.
	 * model.Book)
	 */
	@Override
	public void addBook(Book book) {
		bookDao.add(book);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.softserve.academy.service.BookService#editBook(com.softserve.academy.
	 * model.Book)
	 */
	@Override
	public void editBook(Book book) {
		bookDao.edit(book);
//		Book entity = bookDao.findById(book.getId());
//		if (entity != null) {
//			entity.setName(book.getName());
//			entity.setStatus(book.getStatus());
//			entity.setId_authors(book.getId_authors());
//		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softserve.academy.service.BookService#deleteBookById(int)
	 */
	@Override
	public void deleteBookById(int bookId) {
		bookDao.deleteBook(bookId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softserve.academy.service.BookService#findAllBook()
	 */
	@Override
	public List<Book> findAllBook() {
		return bookDao.findAllBooks();
	}

}
