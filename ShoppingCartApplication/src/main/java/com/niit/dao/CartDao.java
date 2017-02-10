package com.niit.dao;

import java.util.List;

import com.niit.domain.Cart;

public interface CartDao {
	public void add(Cart cart);
	public void delete(int cartId);
	public Cart getCart(int cartId);
	public List getAllCart();
	List getbyuserid(int id);

}
