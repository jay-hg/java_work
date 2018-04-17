package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Category;
import com.how2java.util.Page;

public interface CategoryService {
	public List<Category> list();
	public int update(Category category);
	public void delete(int id);
	public int add(Category category);
	public Category get(int id);
	
	void addTwo();
}
