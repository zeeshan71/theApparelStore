package com.birlasoft.theapparelstore.theApparelStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birlasoft.theapparelstore.theApparelStore.daos.CartDAO;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Cart;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Product;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	ProductService productservice;
	
	@Autowired
	CartDAO dao;
	@Override
	public void addToCart(int id, String email) {
		// TODO Auto-generated method stub
		List<Product> productlist= new ArrayList<>();
		Product product= productservice.getProduct(id);
		productlist.add(product);
		
		Cart cart = new Cart();
		
		cart.setProducts(productlist);
		cart.setEmail(email);
		cart.setPrice(product.getPrice());
		
		dao.save(cart);
		
		
	}
	@Override
	public List<Cart> getCartbyEmail(String email) {
		// TODO Auto-generated method stub
		return dao.getCartbyEmail(email);
	}
	
	@Override
	public void deleteproductincart(int cartid) {
		// TODO Auto-generated method stub
		
		Optional<Cart> cart= dao.findById(cartid);
		if(cart.isPresent())
		{
			dao.deleteById(cartid);
		}
		
		
		
	}
	@Override
	public double getTotalofPrice(String email) {
		// TODO Auto-generated method stub
		return dao.sumofPrice(email);
	}
	@Override
	public void deletecart(String email) {
		// TODO Auto-generated method stub
			
		dao.deletecart(email);
		
	}
	
	
	
	

}
