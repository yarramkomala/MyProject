package com.niit.serviceimpl;

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
	@Override
	public void insertRow(UserInfo userinfo) {
    	  userDao.insertRow(userinfo);
		
		
	}

}
