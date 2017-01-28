package com.niit.controllers;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.UserDao;
import com.niit.domain.Product;
import com.niit.domain.UserInfo;
import com.niit.service.ProductService;
import com.niit.service.UserService;;

@Controller //which specifies this is a controller class
public class LoginPageController {
	@Autowired //auto wire the bean by matching data type.
	UserService userservice;
	@Autowired
	UserDao userDao;
	@Autowired
	ProductService productservice;
	
	//method for index page
	@RequestMapping(value={"/","/index","/home"})
	public String getHome(Map<String, Object>map) {
		Product productResult = new Product();
		map.put("productModel",productResult);
	    map.put("productmodelList", productservice.getProductList());
		return "index";
	}

	

//	@RequestMapping("/register")
//	public String getRegister() {
//UserInfo userinfo=new UserInfo();
//	map.put("userinfo", userinfo);
//	
//	System.out.println(userinfo);
//		
//		return "register";
//		}}
	
//	@RequestMapping("/register.do")
//	public String doAction(@Valid @ModelAttribute UserInfo userinfo,BindingResult result,@RequestParam String action,Map<String,Object> map){
//		
//		  if (result.hasErrors()) {
//	            return "failure";
//	        }
//	 
//	      
////		userservice.insertRow(userinfo);
//		
//		return "success";
//	}
//	

}
