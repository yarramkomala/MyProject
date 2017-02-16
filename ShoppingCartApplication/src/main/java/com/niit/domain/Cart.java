package com.niit.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Cart")
public class Cart implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cartId;
	private double total;
	private int quantity;
	private String date_time;
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@ManyToOne()
	@JoinColumn(name = "id")
	private Product product_fk;
	@OneToMany(mappedBy = "cartid", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItems> cartItems;
	@OneToOne
	@JoinColumn(name = "userid")
	@JsonIgnore

	private UserInfo userid;

	public UserInfo getUserid() {
		return userid;
	}

	public void setUserid(UserInfo userid) {
		this.userid = userid;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public Product getProduct_fk() {
		return product_fk;
	}

	public void setProduct_fk(Product product_fk) {
		this.product_fk = product_fk;
	}

	public List<CartItems> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItems> cartItems) {
		this.cartItems = cartItems;
	}

}
