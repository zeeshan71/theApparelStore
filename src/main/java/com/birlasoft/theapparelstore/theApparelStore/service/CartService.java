package com.birlasoft.theapparelstore.theApparelStore.service;

import java.util.List;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Cart;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Product;

public interface CartService {
	
	
	public void addToCart(int id, String email);
	
	public List<Cart> getCartbyEmail(String email);
	
	public void deleteproductincart(int cartid);

	public double getTotalofPrice(String email);
	
	public void deletecart(String email);
}
