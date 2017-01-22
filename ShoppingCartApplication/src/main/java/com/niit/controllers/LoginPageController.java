package com.niit.controllers;
import java.util.Map;

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

@Controller
public class LoginPageController {
	@Autowired
	UserService userservice;
	@Autowired
	UserDao userDao;
	@Autowired
	ProductService productservice;
	@RequestMapping(value={"/","/uhome"})
	public String getHome(Map<String, Object>map) {
		Product productResult = new Product();
		map.put("productModel",productResult);
	    map.put("productmodelList", productservice.getProductList());
		return "index";
	}
	
//	@RequestMapping("/login")
//	public String login(@RequestParam(value="email") String email,@RequestParam(value="password") String pwd){
//		
//		
//		return "login";
//	}
	
	@RequestMapping("/register")
	public String getRegister(Map<String,Object> map) {
	UserInfo userinfo=new UserInfo();
	map.put("userinfo", userinfo);
	
	System.out.println(userinfo);
		
		return "register";
	}
	@RequestMapping("/register.do")
	public String doAction(@ModelAttribute UserInfo userinfo,BindingResult result,@RequestParam String action,Map<String,Object> map){
		

		userservice.insertRow(userinfo);
		
		return "security/login";
	}
	
}

