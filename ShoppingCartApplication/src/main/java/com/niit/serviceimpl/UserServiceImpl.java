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



	@Override
	@Transactional
	public List<UserInfo> getUserid() {
		
		return userDao.getUserid();
	}



	@Override
	public List<UserInfo> getUserNamePassword() {
		// TODO Auto-generated method stub
	
		return 	userDao.getUserNamePassword();
	}

	
	
}
