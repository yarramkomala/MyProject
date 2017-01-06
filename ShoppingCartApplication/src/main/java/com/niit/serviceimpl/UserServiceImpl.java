package com.niit.serviceimpl;

import java.util.List;

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
	 
      
	
	@Transactional
	public void insertRow(UserInfo userinfo) {
    	  userDao.insertRow(userinfo);
		
		
	}

	
	@Transactional
	public void updateRow(UserInfo userinfo) {
		userDao.updateRow(userinfo);
		
	}

	@Transactional
	public void deleteRow(String username) {
		userDao.deleteRow(username);
		
	}

	@Transactional
	public List getList() {
		
		return userDao.getList();
	}

	@Override
	public UserInfo getRowById(String username) {
	
		return userDao.getRowById(username);
	}

}
