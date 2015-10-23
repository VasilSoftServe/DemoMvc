/**
 * 
 */
package com.softserve.academy.service.book;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.academy.dao.book.BookDao;
import com.softserve.academy.model.Book;

/**
 * @author 123
 *
 */

@Service("bookService")
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.softserve.academy.service.BookService#findById(long)
	 */
	@Override
	public Book findById(long id) {
		return dao.findById(id);
	}

	@Override
	public void saveBook(Book book) {
		dao.saveBook(book);		
	}

	@Override
	public void updateBook(Book book) {
		Book entity = dao.findById(book.getId());
        if(entity!=null){
            entity.setTitle(book.getTitle());
            entity.setStatus(book.getStatus());
        }
	}

	@Override
	public void deleteBook(Book book) {
		dao.deleteBookById(book.getId());
	}

	@Override
	public Set<Book> findAllBooks() {
		return dao.findAllBooks();
	}
}
