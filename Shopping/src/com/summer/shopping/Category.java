package com.summer.shopping;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private int id;
	private String name;
	private String descr;
	private int pid;
	private boolean leaf;
	private int grade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public static void add(Category c) {
		int leaf = 0;
		if(!c.isLeaf()) {
			leaf = 1;
		}
		CategoryDAO.save(c.getName(), c.getDescr(), c.getPid(), leaf, c.getGrade());
	}
	
	public static void addTopCategory(String name, String descr) {
		/*Category c = new Category();
		c.setId(-1);
		c.setName(name);
		c.setDescr(descr);
		c.setPid(0);
		c.setLeaf(true);
		c.setGrade(1);
		add(c);*/
		addChildCategory(0,name,descr,1);
	}
	
	public static void addChildCategory(int pid, String name, String descr, int grade) {
		Category c = new Category();
		c.setId(-1);
		c.setName(name);
		c.setDescr(descr);
		c.setPid(pid);
		c.setLeaf(true);
		c.setGrade(grade);
		add(c);
	}
	
	public static void addCategory(Category c) {
		add(c);
	}
	
	public static void deleteCategory(int id, int pid) {
		CategoryDAO.delete(id, pid);
	}
	
	public static List<Category> getCategories() {
		List<Category> categories = new ArrayList<Category>();
		CategoryDAO.getCategories(categories, 0);
		return categories;
	}
	
	public static Category loadById(int id) {
		return CategoryDAO.loadById(id);
	}
	
	public void modify() {
		CategoryDAO.update(this);
	}
	
	public static List<Category> getChildCategories(int parentId) {
		return CategoryDAO.getChildCategories(parentId);
	}
}
