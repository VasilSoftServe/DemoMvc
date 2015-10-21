/**
 * 
 */
package com.softserve.academy.service.book;

import java.util.List;


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
            entity.setName(book.getName());
            entity.setStatus(book.getStatus());
        }
	}

	@Override
	public void deleteBookById(long id) {
		dao.deleteBookById(id);
	}

	@Override
	public List<Book> findAllBooks() {
		return dao.findAllBooks();
	}
}
