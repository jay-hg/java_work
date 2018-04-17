package com.summer.shopping;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<CartItem> items = new ArrayList<CartItem>();
	
	public void add(CartItem item) {
		CartItem ci = null;
		for(int i=0;i<items.size();i++) {
			ci = items.get(i);
			if(item.getProduct().getId()==ci.getProduct().getId()) {
				ci.setCount(ci.getCount()+1);
				return;
			}
		}
		items.add(item);
	}
	
	public List<CartItem> getCartItems() {
		return items;
	}
	
	public double getTotalPrice() {
		double totalPrice = 0;
		CartItem ci = null;
		for(int i=0;i<items.size();i++) {
			ci = items.get(i);
			totalPrice += ci.getTotalPrice();
		}
		
		totalPrice = Math.round(totalPrice*100)/100.0;
		return totalPrice;
	}
}
