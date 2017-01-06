package com.niit.service;

import java.util.List;

import com.niit.domain.UserInfo;

public interface UserService {
	public void insertRow(UserInfo userinfo);
	public void updateRow(UserInfo userinfo);
	public void deleteRow(String username);

	 public List getList();
	 public UserInfo getRowById(String username);
}
