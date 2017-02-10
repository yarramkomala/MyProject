package com.niit.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.niit.domain.Category;
import com.niit.domain.Product;
import com.niit.service.CategoryService;
import com.niit.service.ProductService;

@Controller
public class CategoryControl {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	ProductService productservice;

	@RequestMapping("/category")
	public String setupcatForm(Map<String, Object> map, @ModelAttribute("category") Category category,
			BindingResult result) {                                  //cmd name , pojo class, pojo obj 
		map.put("category", category);//map.put("command name or
		// key",valuei.e the object of pojo class )
		map.put("categoryList", categoryService.getAllCategory());
		return "category";//jsp page
	}

	@RequestMapping(value = "categoryadd", method = RequestMethod.POST)
	public String docatActions(@ModelAttribute("category") Category category, BindingResult result,
			@RequestParam String action/* the name of the button */, Map<String, Object> map) {

		//Category category = new Category();
		switch (action.toLowerCase()) {
		case "add":
			categoryService.add(category);

			break;
		case "edit":
			categoryService.edit(category);
			break;
		case "delete":
			categoryService.delete(category.getCid());
			System.out.println("delete in controller");
			break;
		}

		//categoryResult = category;
		map.put("category", category);//map.put("command name or
		// key",valuei.e the object of pojo
		// class)
		map.put("categoryList", categoryService.getAllCategory());
		return "category";//jsp page
	}
	@RequestMapping("/deleteCategory")
	public String deletecat(Map<String, Object> map,@RequestParam int id) {
		categoryService.delete(id);
		System.out.println("delete in controller");
		map.put("categoryList", categoryService.getAllCategory());
		return "categoryDetails";//jsp page

	}
	@RequestMapping("/viewDetails")
	public String viewDetail(@RequestParam("pdt1") int id, Map<String, Object> map, Product product) {
		
		Product p = productservice.getRowById(id);
		map.put("product", p);
		map.put("categoryList", categoryService.getAllCategory());
		return "viewDetails";
	}
	@RequestMapping("/delete1")
	public String deleteProduct(Map<String, Object> map,@RequestParam int id22) {
        //action id called on viewall
productservice.deleteRow(id22);
map.put("categoryList", categoryService.getAllCategory());
map.put("productList", productservice.getProductList());
return "allproduct"; 
		
	}

}
