package com.niit.serviceimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.UserDao;
import com.niit.domain.UserInfo;
import com.niit.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
@Autowired
SessionFactory session;
	@Transactional
	public void insertRow(UserInfo userinfo) {
		userDao.insertRow(userinfo);

	}

	@Override
	@Transactional
	public List<UserInfo> getUserid() {

		return userDao.getUserid();
	}
	@Override
	@Transactional
	public List<UserInfo> getUserByName(String username) {
		
		  String Query="from Register where username='"+username+"'";
	  @SuppressWarnings("unchecked")
		  List<UserInfo> productList = session.getCurrentSession().createQuery(Query).list();
		 
		  return productList;
	}
	@Transactional
	public List getbyuserid(int id)
	{
		String Query="from CartItems where userid='"+id+"'";
		@SuppressWarnings("unchecked")
		List<UserInfo> crtitem = session.getCurrentSession().createQuery(Query).list();
		return crtitem;
	}

	@Override
	public void edit(UserInfo userInfo) {
		userDao.edit(userInfo);
		
	}
	

}
