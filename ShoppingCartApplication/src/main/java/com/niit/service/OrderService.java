package com.niit.service;

import java.util.List;

import com.niit.domain.Cart;
import com.niit.domain.Orders;

public interface OrderService {
	public void add(String name1, Cart carts);
	public void orderadd(String username);
	public void Cartitems();
	
	public  List getAllOrders();
}