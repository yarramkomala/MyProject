package com.niit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.OrderDao;
import com.niit.domain.Cart;
import com.niit.domain.Orders;
import com.niit.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
      OrderDao pd;
	
	
	@Transactional
	public void Cartitems() {
		pd.Cartitems();
}
	@Transactional
	public List getAllOrders() {
		
		return pd.getAllOrders();
	}
	@Transactional
	public void add(Cart carts) {
		pd.add(carts);
		
	}
	@Transactional
	public void orderadd(String username) {
		pd.orderadd(username);
		
	}
}