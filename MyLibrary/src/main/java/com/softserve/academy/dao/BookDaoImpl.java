/**
 * 
 */
package com.softserve.academy.dao;

import java.util.List;
//
//import org.hibernate.Criteria;
//import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.softserve.academy.model.Book;

/**
 * @author 123
 *
 */
public class BookDaoImpl extends AbstractDao<Integer, Book> implements BookDao {

	@Autowired
	private SessionFactory session;
//	Query query;
	/* (non-Javadoc)
	 * @see com.softserve.academy.dao.BookDao#add(com.softserve.academy.model.Book)
	 */
	@Override
	public void add(Book book) {
		session.getCurrentSession().save(book);
//		persist(book);

	}

	/* (non-Javadoc)
	 * @see com.softserve.academy.dao.BookDao#edit(com.softserve.academy.model.Book)
	 */
	@Override
	public void edit(Book book) {
		session.getCurrentSession().update(book);

	}

	/* (non-Javadoc)
	 * @see com.softserve.academy.dao.BookDao#deleteBook(int)
	 */
	@Override
	public void deleteBook(int bookId) {
		session.getCurrentSession().delete(findById(bookId));
		
//		query = getSession().createSQLQuery("delete from book where id = :id");
//		query.setString(bookId, "id");
//		query.executeUpdate();
	}

	/* (non-Javadoc)
	 * @see com.softserve.academy.dao.BookDao#findById(int)
	 */
	@Override
	public Book findById(int bookId) {
		return (Book) session.getCurrentSession().get(Book.class, bookId);
//		return getByKey(bookId);
	}

	/* (non-Javadoc)
	 * @see com.softserve.academy.dao.BookDao#findAllBooks()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> findAllBooks() {
		return session.getCurrentSession().createQuery("from book").list();
//		Criteria criteria = createEntityCriteria();
//		return (List<Book>)criteria.list();
	}

}
