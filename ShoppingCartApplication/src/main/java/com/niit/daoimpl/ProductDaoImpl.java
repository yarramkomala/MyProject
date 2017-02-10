package com.niit.daoimpl;

import java.io.Serializable;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.domain.Product;
@Repository //creating bean for this class and importing DAO into DI container 
public class ProductDaoImpl implements ProductDao {

	
	@Autowired
	private SessionFactory session;
	
	@Override
	@Transactional //The database transaction happens inside this method
	public void insertRow(Product product) {
		
		   session.getCurrentSession().save(product);
		
	}

	@Override
	@Transactional
	public List getProductList() {
		
		return session.getCurrentSession().createQuery("from Product").list();
	}

	@Override
	@Transactional
	public Product getRowById(int id) {
		 
		
		  return  (Product) session.getCurrentSession().get(Product.class, id);
	}

	@Override
	@Transactional
	public void updateRow(Product product) {
		session.getCurrentSession().update(product);
	}

	@Override
	@Transactional
	public void deleteRow(int id) {
		
		  session.getCurrentSession().delete(getProduct(id));
		 
	}
	@Override
	public Product getProduct(int id) {
		return (Product)session.getCurrentSession().get(Product.class, id);
	}
	@Transactional(propagation = Propagation.SUPPORTS)
	public List getAllProductfromCategory(String id) {
	
		String query="from Product where CATEGORYNAME=:output";
		
		List image=session.getCurrentSession().createQuery(query).setParameter("output",id).list();
		return image;
	}


}
