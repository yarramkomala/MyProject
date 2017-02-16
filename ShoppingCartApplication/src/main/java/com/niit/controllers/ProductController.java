package com.niit.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.domain.CartItems;
import com.niit.domain.Category;
import com.niit.domain.Product;
import com.niit.service.CategoryService;
import com.niit.service.ProductService;
@Controller
public class ProductController {
	
	@Autowired
	ProductService pservice;
	@Autowired
	CategoryService categoryService;
	Product productObject=null;
	ServletContext servletContext;
	//for admin getting addproduct page
	@RequestMapping("/admin")
	public  ModelAndView  getProductPage( @ModelAttribute Product product,Map<String, Object> map) {
map.put("productList",pservice.getProductList());
		map.put("categoryList",categoryService.getAllCategory());
		return new  ModelAndView("addproduct");
	}
	//for adding product details into database
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public  ModelAndView getProduct(@Valid Product product,BindingResult result,HttpServletRequest hm,Map<String, Object> map) {
		System.out.println("inside a method");
		map.put("categoryList",categoryService.getAllCategory());
     servletContext =hm.getServletContext();
     //if errors or nulls entered in addproduct.jsp it will check and returns addproduct.jsp page
     if (result.hasErrors()) {
    	 System.out.println("inside if");
			return new ModelAndView("addproduct");
		} else {
			
     if (!product.getImage().isEmpty()) { //if image is not empty
    	 System.out.println("get image");
    	 try {
    		 System.out.println("get image "+servletContext);
			byte[] bytes = product.getImage().getBytes(); //read image in bytes and stores in byte
			System.out.println("get image "+servletContext.getRealPath("/"));
			// Creating the directory to store file
			String rootPath = servletContext.getRealPath("/");
			
			System.out.println("get image "+rootPath);
			File dir = new File(rootPath + File.separator + "Resources/images"); //creatiing directory in server
			System.out.println("file"+dir.toString());
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
			
			boolean exists = false;//in this e check with category table and insert the details into product and category tables
			List<Category> category = categoryService.getAllCategory();
			for(Category x:category) //taking values from category table and placing these into x variable
			{
				if(product.getCategoryName().equals(x.getCategoryName())==true)
				{
					product.setCategoryid(x);
					pservice.insertRow(product);
					 exists = true;
					break;
				}
			}
			if(!exists){
			Category cat = new Category();
			cat.setCategoryName(product.getCategoryName());
			categoryService.add(cat);
			product.setCategoryid(cat);}
			/*pservice.insertRow(product);*/
    	 }
			
			return new ModelAndView("redirect:plist");
			} catch (Exception e) {
				e.printStackTrace();
				return new ModelAndView("addproduct");
			}
		} else {
			return new ModelAndView("addproduct");
		}
		}
		
    
	}
	//for getting list of products
	 @RequestMapping("/plist")
	 public ModelAndView getPList() {
	  List productList = pservice.getProductList();
	  return new ModelAndView("productlist", "productList", productList);
	 }
     //for deleting product
	 @RequestMapping("/pdelete")
	 public ModelAndView deleteUser(@RequestParam int id) {
	  pservice.deleteRow(id);
	  return new ModelAndView("redirect:plist");
	 }
     //for editing details of product
	 @RequestMapping("/pedit")
	 public ModelAndView editUser(@RequestParam int id,
	   @ModelAttribute Product product) {
	   productObject = pservice.getRowById(id);
	  return new ModelAndView("pedit", "productObject", productObject);
	 }
     //updating products into database
	 @RequestMapping("/pupdate")
	 public ModelAndView updateUser(@ModelAttribute Product product,HttpServletRequest hm) {
		 int id = productObject.getId();
		 System.out.println(id);
		 product.setId(id);
		 servletContext =hm.getServletContext();
		 pservice.updateRow(product);
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
				 pservice.updateRow(product);
	    	 
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
	 //for displaying product details to user
	 @RequestMapping("/disimage")
	 public  ModelAndView  getProductImages(@ModelAttribute Product product,Map<String,Object> map) {
		ModelAndView mv= new  ModelAndView("pimage");
map.put("productList",pservice.getProductList());
map.put("img",product.getproductName());
			return mv ;
		}
	 
	 public void updateproduct( List<CartItems> cartitems)
		{		Product product = new Product();
				int id;
				for(int i=0;i<cartitems.size();i++)
				{	
					id=cartitems.get(i).getProductid_fk().getId();
					product=pservice.getRowById(id);
					
					product.setQuantity(product.getQuantity()-cartitems.get(i).getQuantity());
					
					pservice.updateRow(product);
				}
		}

}
