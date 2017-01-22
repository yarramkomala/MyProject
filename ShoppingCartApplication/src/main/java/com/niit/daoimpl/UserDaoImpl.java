package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.domain.UserInfo;
import com.niit.domain.UserRoles;
import com.niit.dao.UserDao;

@Repository
@EnableTransactionManagement
public class UserDaoImpl implements UserDao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertRow(UserInfo userinfo) {
		Session session = sessionFactory.getCurrentSession();

		userinfo.setEnabled(true);
		UserRoles r = new UserRoles();
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
	public UserInfo getByUserName(String username, String password) {

		return (UserInfo) sessionFactory.getCurrentSession()
				.createQuery("from USERINFO where USERNAME=? AND 	PASSWORD=? where USERNAME=?").list();
	}

}
