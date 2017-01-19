package com.niit.domain;

import java.io.Serializable;
import java.util.Set;
import com.niit.domain.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class UserRoles implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserRoles() {
	}

	@Id
	private int rid;
	private String role;

	@OneToOne
	@JoinColumn(name = "userid")
	private UserInfo userid;

	public UserInfo getUserid() {
		return userid;
	}

	public void setUserid(UserInfo userid) {
		this.userid = userid;
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
