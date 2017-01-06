package com.niit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.domain.UserInfo;
import com.niit.dao.UserDao;
@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao{
	 @Autowired
	 SessionFactory sessionFactory;
	
	 
	 
	@Override
	@Transactional
	public void insertRow(UserInfo userinfo) {
		/*Session session = sessionFactory.getCurrentSession();	
	Transaction tx = session.beginTransaction();
	session.save(userinfo);
	tx.commit();
	session.close();*/
		final Session session = sessionFactory.getCurrentSession();
	 
	try {
	  final Transaction transaction = session.beginTransaction();
	  try {
	    // The real work is here
	    transaction.commit();
	  } catch (Exception ex) {
	    // Log the exception here
	    //transaction.rollback();
	    //throw ex;
	  }
	} finally {
		//session.close();
	}
	
	
	}
//	@Override
//	public void updateRow(UserInfo userinfo) {
//		
//		
//	}
//	@Override
//	public void deleteRow(String username) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public List getList() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	@Override
//	public UserInfo getRowById(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
}



