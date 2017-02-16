package com.niit.dao;

import java.util.List;

import com.niit.domain.Cart;
import com.niit.domain.Orders;

public interface OrderDao {
	public void add(String username,Cart carts);
	public void orderadd(String username);
	public void Cartitems();
	public List getAllOrders();
	
	
	
	


}
