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
import com.niit.domain.Category;
import com.niit.domain.Product;
import com.niit.domain.UserInfo;
import com.niit.service.CategoryService;
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
	@Autowired
	CategoryService categoryService;
	
	//method for index page
	@RequestMapping(value={"/","/index","/home"})
	public String getHome(Map<String, Object>map) {
		Product productResult = new Product();
	
		map.put("productModel",productResult);
	    map.put("productmodelList", productservice.getProductList());
	    map.put("categoryList",categoryService.getAllCategory());
		return "index";
	}

	@RequestMapping("/allproduct")
	public String view(@RequestParam("pdt") String id, Map<String, Object> map) {
		System.out.println("allproduct");
		map.put("productList", productservice.getAllProductfromCategory(id));
		map.put("categoryList", categoryService.getAllCategory());
		return "allproduct";
	}



}
