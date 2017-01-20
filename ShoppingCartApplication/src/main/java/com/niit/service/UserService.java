package com.niit.service;

import java.util.List;

import com.niit.domain.UserInfo;

public interface UserService {
	public void insertRow(UserInfo userinfo);
	
	 public List<UserInfo> getUserid();
	 public List<UserInfo> getUserNamePassword();
	
}
