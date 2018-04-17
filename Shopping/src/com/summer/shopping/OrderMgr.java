package com.summer.shopping;

import java.util.Date;
import java.util.List;

import com.summer.shopping.dao.OrderDAO;
import com.summer.shopping.dao.OrderMysqlDAO;

public class OrderMgr {
	private static OrderMgr om = null;
	private OrderDAO odao = null;
	
	private OrderMgr() {}
	
	static {
		if(om == null) {
			om = new OrderMgr();
			om.setDao(new OrderMysqlDAO());
		}
	}
	
	public static OrderMgr getInstance() {
		return om;
	}
	
	public OrderDAO getDao() {
		return odao;
	}

	public void setDao(OrderDAO odao) {
		this.odao = odao;
	}

	public void saveOrder(Order o) {
		odao.saveOrder(o);
	}
	
	public int getOrders(List<Order> orders, int pageNo, int pageSize) {
		return odao.getOrders(orders,pageNo,pageSize);
	}
	
	public Order loadById(int id) {
		return odao.loadById(id);
	}
	
	public void updateStatus(int status) {
		odao.updateStatus(status);
	}
	/*public boolean deleteProductsById(int[] id) {
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
	
	
	
	public boolean update(Product p) {
		return pdao.update(p);
	}
	
	public List<Product> getLatestProducts(int count) {
		return pdao.getLatestProducts(count);
	}*/
}
