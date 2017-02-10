package com.niit.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.UserDao;
import com.niit.domain.CartItems;
import com.niit.domain.Product;
import com.niit.domain.UserInfo;
import com.niit.service.CartItemsService;
import com.niit.service.CategoryService;
import com.niit.service.ProductService;
@Controller
public class CartController {
	@Autowired
	ProductService productService;
	@Autowired
	CartItemsService cartItemsService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	UserDao ud;
	
	@RequestMapping("/addtocart")
	public String AddtoCart(@RequestParam("cart") int id, Map<String, Object> map, Product product,HttpSession session) 
	{
		CartItems cart = new CartItems();
		Product p1 = productService.getRowById(id);	
		
		@SuppressWarnings("unchecked")
		List<CartItems> crt=cartItemsService.getAllCartitems();
		/* search the table whether the product is new or existing*/
		for(int i=0;i<crt.size();i++)
		{	
			//get product id from the cartitem table
			int tempid=crt.get(i).getProductid_fk().getId();
			//for update the existing product
			if(tempid==id)
			{	
				int quantity=crt.get(i).getQuantity()+1;//if same product added,it wil increase the quantity
				crt.get(i).setQuantity(quantity);
				int price=p1.getPrice()*quantity;//this wil multiply prod price * qty
				crt.get(i).setTotalPrice(price);
				cartItemsService.update(crt.get(i));
				map.put("cartList", cartItemsService.getAllCartitems());
				
				return "Cart";
			}
		}
		
		cart.setQuantity(1);//setter method of quantity in cartitems table
		cart.setTotalPrice(p1.getPrice());
		cart.setProductid_fk(p1);//foreign key of Productid
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 String username = auth.getName();  
		 		 System.out.println(username);
		 List<UserInfo> userDetail = ud.getUserByName(username);//user details are stored in userDetail object
		  System.out.println("It is entering into the billing address");
		 //TO STORE  THE USERID IN BILLINGADDRESS TABLE
		   for(int i=0;i<userDetail .size();i++)
		   { 
		    System.out.println("It is entering into block which is to add user id");
			cart.setUserid(userDetail.get(i));
			
		   }
		cartItemsService.add(cart);//add the quantity,total,productid in cartitems table using the cart object
		map.put("product", p1);
		map.put("cartList", cartItemsService.getAllCartitems());
		session.setAttribute("cartlength", cartItemsService.cartLength());
		
		map.put("categoryList", categoryService.getAllCategory());
		map.put("productList", productService.getProductList());
		return "Cart";

	}
	@RequestMapping("/remove")
	public String rem(@RequestParam("pdt3") int id, Map<String, Object> map,HttpSession session) {
		cartItemsService.delete(id);
		map.put("cartList", cartItemsService.getAllCartitems());
		session.setAttribute("cartlength", cartItemsService.cartLength());
		return "Cart";
	}
	@RequestMapping("/viewall")
	public String view(Map<String, Object> map) {
		map.put("categoryList", categoryService.getAllCategory());
		return "viewall";
	}
	

}
