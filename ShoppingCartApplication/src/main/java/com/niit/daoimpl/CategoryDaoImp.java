package com.niit.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CategoryDao;
import com.niit.domain.Category;
@Repository
public class CategoryDaoImp implements CategoryDao {
	@Autowired
	private SessionFactory session;

	@Transactional(propagation = Propagation.SUPPORTS)
	public void add(Category category) {
		session.getCurrentSession().save(category);
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void edit(Category category) {
		session.getCurrentSession().update(category);
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(int categoryId) {
		session.getCurrentSession().delete(getCategory(categoryId));
		
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public Category getCategory(int categoryId) {
		return (Category)session.getCurrentSession().get(Category.class, categoryId);
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	public List getAllCategory() {
		return session.getCurrentSession().createQuery("from Category").list();
	}

}
