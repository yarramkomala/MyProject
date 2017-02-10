package com.niit.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.UserDao;
import com.niit.domain.Cart;
import com.niit.domain.CartItems;
import com.niit.domain.Orders;
import com.niit.domain.UserInfo;
import com.niit.service.CartItemsService;
import com.niit.service.CartService;
import com.niit.service.OrderService;
@Controller
public class OrderController {
	@Autowired
	UserDao ud;
	@Autowired
	private CartService cs;
	@Autowired
	OrderService ps;
	@Autowired
	CartItemsService cartItems;
	@Autowired
	ProductController  productController;
	@RequestMapping("/thanks")
	
	 //for mapping the order table and cart table with customer table after sucessful purchase
		public String getuserdata(HttpServletRequest req)
		{	//for getting the loggedin username
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			 String name = auth.getName(); 
			 System.out.println(name);
			 @SuppressWarnings("unchecked")
			List<CartItems> list=cartItems.getAllProduct();
			 Cart cart=new Cart();
			 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
		     Date date = new Date();
		     DateFormat dateFormats = new SimpleDateFormat("hh:mm:ss a");
		     Calendar cal = Calendar.getInstance();
		     productController.updateproduct(list);
			 for (int i=0;i<list.size();i++)
			 {
			     String Date=dateFormat.format(date);
	             String Time=dateFormats.format(cal.getTime());
				 cart.setDate_time(Date);
				 cart.setTime(Time);
	             cart.setProduct_fk(list.get(i).getProductid_fk());
				 cart.setQuantity(list.get(i).getQuantity());
				 cart.setTotal(list.get(i).getTotalPrice());
				 String name1= auth.getName();
				 ps.add(cart); 
				/* ps.add(cart);
				 */
			 }
			   
		    ps.orderadd(name);
		     @SuppressWarnings("unchecked")
			List<Orders> ordlist=ps.getAllOrders();
		   /*  email.send(name,ordlist.get(ordlist.size()-1).getOrderid());*/
		     ps.Cartitems();	    
		      return"index";
		     }
}
