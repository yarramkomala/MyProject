package com.niit.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ShippmentDao;
import com.niit.domain.Shippment;
@Repository
@Transactional
public class ShippmentDaoImp implements ShippmentDao {
	@Autowired
	private SessionFactory session;

	@Transactional(propagation=Propagation.SUPPORTS)
	public void add(Shippment shippment) {
		session.getCurrentSession().saveOrUpdate(shippment);
		
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	public void edit(Shippment shippment) {
		session.getCurrentSession().update(shippment);
		
	}

	

}
