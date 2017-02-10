package com.niit.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CartItems")
public class CartItems implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartItems_id;
	@ManyToOne
	@JoinColumn(name = "cartId")
	@JsonIgnore
	private Cart cartid;
	
	private int quantity;
	@ManyToOne()
	@JoinColumn(name = "id")
	private Product productid_fk;
	@OneToOne
	@JoinColumn(name="userid")
	
	private UserInfo userid;
	private int totalPrice;
	
	public UserInfo getUserid() {
		return userid;
	}
	public void setUserid(UserInfo userid) {
		this.userid = userid;
	}

	
	public CartItems(){
		
	}
	public CartItems(int cartItems_id, Cart cartid, int quantity, Product productid_fk, int totalPrice) {
		super();
		this.cartItems_id = cartItems_id;
		this.cartid = cartid;
		this.quantity = quantity;
		this.productid_fk = productid_fk;
		this.totalPrice = totalPrice;
	}

	public int getCartItems_id() {
		return cartItems_id;
	}

	public void setCartItems_id(int cartItems_id) {
		this.cartItems_id = cartItems_id;
	}

	public Cart getCartid() {
		return cartid;
	}

	public void setCartid(Cart cartid) {
		this.cartid = cartid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProductid_fk() {
		return productid_fk;
	}

	public void setProductid_fk(Product productid_fk) {
		this.productid_fk = productid_fk;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	
}
