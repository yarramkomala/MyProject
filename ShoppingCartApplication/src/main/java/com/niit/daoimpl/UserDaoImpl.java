package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.domain.Shippment;
import com.niit.domain.UserInfo;
import com.niit.domain.UserRoles;
import com.niit.dao.UserDao;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;
@Autowired
SessionFactory session;
	@Override
	@Transactional //The database transaction happens inside this method
	public void insertRow(UserInfo userinfo) {
		Session session = sessionFactory.getCurrentSession();

		userinfo.setEnabled(true);
		UserRoles r = new UserRoles();
		Shippment s=new Shippment();
		s.setUsername(userinfo);
		r.setUserid(userinfo);
		r.setRole("ROLE_USER");
		session.saveOrUpdate(userinfo);
		session.saveOrUpdate(r);

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserInfo> getUserid() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from USERINFO").list();
	}
	@Override
	@Transactional
	public List<UserInfo> getUserByName(String username) {
		
		  String Query="from UserInfo where username='"+username+"'";
	  @SuppressWarnings("unchecked")
		  List<UserInfo> productList = session.getCurrentSession().createQuery(Query).list();
		 
		  return productList;
	}

	@Override
	@Transactional
	public void edit(UserInfo userInfo) {
		session.getCurrentSession().update(userInfo);
		
	}
	

}
