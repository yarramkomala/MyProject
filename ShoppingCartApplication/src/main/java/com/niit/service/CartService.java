package com.niit.service;

import java.util.List;

import com.niit.domain.Cart;

public interface CartService {
	public void add(Cart cart);
	public void delete(int cartId);
	public Cart getCart(int cartId);
	public List getAllCart();
	public List getbyuserid(int id);
}
