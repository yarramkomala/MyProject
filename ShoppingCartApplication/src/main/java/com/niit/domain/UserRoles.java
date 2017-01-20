package com.niit.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserRoles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserRoles() {
	}

	@Id
	private int rid;
	private String role;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USERID")
	private UserInfo userinfo;

	

	public UserInfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
