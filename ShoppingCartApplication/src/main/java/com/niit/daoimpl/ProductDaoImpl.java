package com.niit.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.domain.Product;
@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public int insertRow(Product product) {
		Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(product);
		  tx.commit();
		  Serializable id = session.getIdentifier(product);
		  session.close();
		  return (Integer) id;
		
	}

	@Override
	@Transactional
	public List getProductList() {
		Session session = sessionFactory.openSession();
		 List productList = session.createQuery("from Product").list();
				    
				  session.close();
				  return productList;
		
	}

	@Override
	@Transactional
	public Product getRowById(int id) {
		  Session session = sessionFactory.openSession();
		  Product product = (Product) session.load(Product.class, id);
		  return product;
	}

	@Override
	@Transactional
	public int updateRow(Product product) {
		 Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  session.saveOrUpdate(product);
		  tx.commit();
		  Serializable id = session.getIdentifier(product);
		  session.close();
		  return (Integer) id;
	}

	@Override
	@Transactional
	public int deleteRow(int id) {
		Session session = sessionFactory.openSession();
		  Transaction tx = session.beginTransaction();
		  Product product = (Product) session.load(Product.class, id);
		  session.delete(product);
		  tx.commit();
		  Serializable ids = session.getIdentifier(product);
		  session.close();
		  return (Integer) ids;
	}


}
