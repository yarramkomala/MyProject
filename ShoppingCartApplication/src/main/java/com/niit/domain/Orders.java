package com.niit.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int orderid;
	@OneToOne
	@JoinColumn(name = "cartid")
	private Cart cartid_fk;
	@OneToOne
	@JoinColumn(name = "sid")
	private Shippment sid_fk;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "username")
	private UserInfo emailid_fk;

	public Orders(int orderid,Cart cartid_fk,Shippment sid_fk,UserInfo emailid_fk) {
		super();
		this.orderid = orderid;
		this.cartid_fk = cartid_fk;
		this.sid_fk = sid_fk;
		this.emailid_fk = emailid_fk;
	}

	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public UserInfo getEmailid_fk() {
		return emailid_fk;
	}

	public void setEmailid_fk(UserInfo emailid_fk) {
		this.emailid_fk = emailid_fk;
	}

	public Cart getCartid_fk() {
		return cartid_fk;
	}

	public void setCartid_fk(Cart cartid_fk) {
		this.cartid_fk = cartid_fk;
	}

	public Shippment getSid_fk() {
		return sid_fk;
	}

	public void setSid_fk(Shippment sid_fk) {
		this.sid_fk = sid_fk;
	}
	
}
