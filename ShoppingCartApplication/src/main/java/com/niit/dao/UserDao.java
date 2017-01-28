package com.niit.dao;

import java.util.List;

import com.niit.domain.UserInfo;

public interface UserDao {
	
	public void insertRow(UserInfo userinfo);
	
	 public List<UserInfo> getUserid();
	
	

}
