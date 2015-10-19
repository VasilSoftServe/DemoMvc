package com.softserve.academy.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.academy.model.Author;

@Repository("authorDao")
public class AuthorDaoImpl extends AbstractDao<Long, Author> implements AuthorDao{

	@Override
	public Author findById(Long id) {
		return findById(id);
	}

	@Override
	public void saveAuthor(Author authors) {
		persist(authors);
	}

	@Override
	public void deleteAuthorById(Long id) {
		Query query = getSession().createSQLQuery("delete from authors where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> findAllAuthors() {
		Criteria criteria = createEntityCriteria();
        return (List<Author>) criteria.list();
	}

}
