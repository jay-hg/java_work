package com.summer.shopping.dao;

import java.util.Date;
import java.util.List;

import com.summer.shopping.Product;

public interface ProductDAO {
	public void addProduct(Product c) ;
	
	public boolean deleteProductsById(int[] id) ;
	
	public boolean deleteProductsByCategoryId(int categoryId) ;
		
	public List<Product> getProducts(int pageNo, int pageSize) ;
	
	public int getProducts(List<Product> products, int pageNo, int pageSize);
	
	public int findProducts(List<Product> products, 
											 int[] categoryID,
											 String keyword,
											 double lowPrice,
											 double highPrice,
											 double lowMemberPrice,
											 double highMemberPrice,
											 Date startDate,
											 Date endDate,
											 int pageNo, 
											 int pageSize);

	public List<Product> getProducts();

	public Product loadById(int id);

	public boolean update(Product p);

	public List<Product> getLatestProducts(int count);

}
