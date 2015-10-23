/**
 * 
 */
package com.softserve.academy.dao.book;

import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.softserve.academy.dao.AbstractDao;
import com.softserve.academy.model.Book;


/**
 * @author 123
 *
 */
@Repository("bookDao")
public class BookDaoImpl extends AbstractDao<Long, Book> implements BookDao {

	@Override
	public Book findById(Long id) {
		Book book = getByKey(id);
		if(book!=null){
			Hibernate.initialize(book.getAuthor());
		}
		return book;
	}

	@Override
	public void saveBook(Book book) {
		persist(book);		
	}

	@Override
	public void deleteBookById(Long id) {
		Query query = getSession().createSQLQuery("delete from books where id_book = :id");
        query.setLong("id", id);
        query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public Set<Book> findAllBooks() {
		 Criteria criteria = createEntityCriteria().addOrder(Order.asc("title"));
	        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
	        Set<Book> books = (Set<Book>) criteria.list();
	         
	        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load. 
	        // Uncomment below lines for eagerly fetching of userProfiles if you want.
	        
	        for(Book user : books){
	            Hibernate.initialize(user.getAuthor());
	        }
	        return books;
	}
	
	
}
