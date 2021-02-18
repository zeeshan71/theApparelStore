package com.birlasoft.theapparelstore.theApparelStore.service;

import java.util.List;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Product;


public interface ProductService {

	public void addProduct(String name, double price, 
			List<String>categories, String description,String stock,
			String imagepath1, String imagepath2, String imagepath3);
	
	public List<Product> getProducts();
	
	public Product getProduct(int id);
	
	public void removeProduct(int id);
	
	public void UpdateProduct(Product product,int id);
	
	public void UpdateProductByQuery(int id,String name, double price, String description, String stock);
	
	public List<Product> getProductsBysearch(String search);
}
