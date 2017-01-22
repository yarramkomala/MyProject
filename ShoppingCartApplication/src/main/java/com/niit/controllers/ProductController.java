package com.niit.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.domain.Product;
import com.niit.service.ProductService;
@Controller
public class ProductController {
	
	@Autowired
	ProductService pservice;
	Product productObject=null;
	ServletContext servletContext;
	@RequestMapping("/addproduct")
	public  ModelAndView  getProductPage(@ModelAttribute Product product) {

		return new  ModelAndView("addproduct");
	}
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public  ModelAndView getProduct(@ModelAttribute Product product,HttpServletRequest hm) {
		
     servletContext =hm.getServletContext();
     
     if (!product.getImage().isEmpty()) {
    	 System.out.println("get image");
    	 try {
    		 System.out.println("get image "+servletContext);
			byte[] bytes = product.getImage().getBytes();
			System.out.println("get image "+servletContext.getRealPath("/"));
			// Creating the directory to store file
			String rootPath = servletContext.getRealPath("/");
			
			System.out.println("get image "+rootPath);
			File dir = new File(rootPath + File.separator + "Resources/images");
			System.out.println("filee "+dir.toString());
			if (!dir.exists()){
				System.out.println("filee "+dir.exists());	
				dir.mkdirs();
    	 }else{
    		 System.out.println("filee "+dir.exists());
			// Create the file on server
			File serverFile = new File(dir.getAbsolutePath()
					+ File.separator +product.getproductName()+".jpg");
			System.out.println(serverFile);
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(serverFile));
			stream.write(bytes);
			stream.close();
			System.out.println("server file location"+serverFile.getAbsolutePath());
			pservice.insertRow(product);
    	 }
			return new ModelAndView("redirect:plist");
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("redirect:plist");
			}
		} else {
			return new ModelAndView("redirect:plist");
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
	 @RequestMapping("/disimage")
	 public  ModelAndView  getProductImages(@ModelAttribute Product product,Map<String,Object> map) {
		ModelAndView mv= new  ModelAndView("pimage");
map.put("productList",pservice.getProductList());
map.put("img",product.getproductName());
			return mv ;
		}
	 
	 

}
