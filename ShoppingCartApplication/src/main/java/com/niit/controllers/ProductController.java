package com.niit.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.domain.Product;
import com.niit.service.ProductService;
@Controller
public class ProductController {
	
	@Autowired
	ProductService pservice;
	Product productObject=null;
	@RequestMapping("/addproduct")
	public  ModelAndView  getProductPage(@ModelAttribute Product product) {

		return new  ModelAndView("addproduct");
	}
	
	@RequestMapping("/insertproduct")
	public  ModelAndView getProduct(@ModelAttribute Product product) {
     pservice.insertRow(product);
     if (!product.getImage().isEmpty()) {
    	 try {
			byte[] bytes = product.getImage().getBytes();
			// Creating the directory to store file
			String rootPath = System.getProperty("catalina.home");
			File dir = new File(rootPath + File.separator + "image");
			if (!dir.exists())
				dir.mkdirs();
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator +product.getproductName());
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			return new ModelAndView("redirect:plist");
			} catch (Exception e) {
				return new ModelAndView("redirect:plist");
			}
		} else {
			return new ModelAndView("addproduct");
		}

	}
    
	 @RequestMapping("/plist")
	 public ModelAndView getPList() {
	  List productList = pservice.getProductList();
	  return new ModelAndView("productlist", "productList", productList);
	 }

	 @RequestMapping("/pdelete")
	 public ModelAndView deleteUser(@RequestParam int id) {
	  pservice.deleteRow(id);
	  return new ModelAndView("redirect:plist");
	 }

	 @RequestMapping("/pedit")
	 public ModelAndView editUser(@RequestParam int id,
	   @ModelAttribute Product product) {
	   productObject = pservice.getRowById(id);
	  return new ModelAndView("pedit", "productObject", productObject);
	 }

	 @RequestMapping("/pupdate")
	 public ModelAndView updateUser(@ModelAttribute Product product) {
		 int id = productObject.getId();
		 System.out.println(id);
		 product.setId(id);
		 pservice.updateRow(product);
	  return new ModelAndView("redirect:plist");
	 }

}
