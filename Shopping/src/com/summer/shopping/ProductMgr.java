package com.summer.shopping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.summer.shopping.dao.ProductDAO;
import com.summer.shopping.dao.ProductMysqlDAO;

public class ProductMgr {
	private static ProductMgr pm = null;
	private ProductDAO pdao = null;
	
	private ProductMgr() {}
	
	static {
		if(pm == null) {
			pm = new ProductMgr();
			pm.setDao(new ProductMysqlDAO());
		}
	}
	
	public static ProductMgr getInstance() {
		return pm;
	}
	
	public ProductDAO getDao() {
		return pdao;
	}

	public void setDao(ProductDAO pdao) {
		this.pdao = pdao;
	}

	public void addProduct(Product p) {
		pdao.addProduct(p);
	}
	
	public boolean deleteProductsById(int[] id) {
		if(id.length <= 0) {
			return false;
		}
		return pdao.deleteProductsById(id);
	}
	
	public void deleteProductsByCategoryId(int categoryId) {
		
	}
	
	public void modify(Product p) {
		
	}
	
	public List<Product> getProducts(int pageNo, int pageSize) {
		return pdao.getProducts(pageNo,pageSize);
	}
	
	public int getProducts(List<Product> products, int pageNo, int pageSize) {
		return pdao.getProducts(products,pageNo,pageSize);
	}
	
	public List<Product> getProducts() {
		return pdao.getProducts();
	}
	
	public int findProducts(List<Product> products, int[] categoryID,
											 String keyword,
											 double lowPrice,
											 double highPrice,
											 double lowMemberPrice,
											 double highMemberPrice,
											 Date startDate,
											 Date endDate,
											 int pageNo,
											 int pageSize) {
		
		return pdao.findProducts(products, categoryID, keyword, lowPrice, highPrice, lowMemberPrice, highMemberPrice, startDate, endDate, pageNo, pageSize);
	}
	
	public Product loadById(int id) {
		return pdao.loadById(id);
	}
	
	public boolean update(Product p) {
		return pdao.update(p);
	}
	
	public List<Product> getLatestProducts(int count) {
		return pdao.getLatestProducts(count);
	}
}
