package com.niit.service;

import java.util.List;

import com.niit.domain.Category;

public interface CategoryService {
	public void add(Category category);
	public void edit(Category category);
	public void delete(int categoryId);
	public Category getCategory(int categoryId);
	public List getAllCategory();

}
