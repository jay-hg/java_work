package com.how2java.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;
import com.how2java.util.Page;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryMapper categoryMapper;
	@Override
	public List<Category> list() {
		return categoryMapper.list();
	}
	@Override
	public int update(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.update(category);
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		categoryMapper.delete(id);
	}
	@Override
	public int add(Category category) {
		// TODO Auto-generated method stub
		return categoryMapper.add(category);
	}
	@Override
	public Category get(int id) {
		return categoryMapper.get(id);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	public void addTwo() {
		Category c1 = new Category();
        c1.setName("短的名字");
        categoryMapper.add(c1);
         
        Category c2 = new Category();
        c2.setName("名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,名字长对应字段放不下,");
        categoryMapper.add(c2);
	}
}
