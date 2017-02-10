package com.niit.dao;

import java.util.List;

import com.niit.domain.UserInfo;

public interface UserDao {
	
	public void insertRow(UserInfo userinfo);
	
	 public List<UserInfo> getUserid();
	 public List<UserInfo> getUserByName(String username);

	public void edit(UserInfo userInfo);
	

}
