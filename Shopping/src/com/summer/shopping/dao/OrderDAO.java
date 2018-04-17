package com.summer.shopping.dao;

import java.util.Date;
import java.util.List;

import com.summer.shopping.Order;
import com.summer.shopping.Product;

public interface OrderDAO {
	public void saveOrder(Order o) ;

	public int getOrders(List<Order> orders, int pageNo, int pageSize);

	public Order loadById(int id);

	public void updateStatus(int status);
	
	/*public List<Product> getProducts(int pageNo, int pageSize) ;
	
	public int getProducts(List<Product> products, int pageNo, int pageSize);
	
	public List<Product> getProducts();

	public Product loadById(int id);

	public boolean update(Product p);

	public List<Product> getLatestProducts(int count);*/

}
