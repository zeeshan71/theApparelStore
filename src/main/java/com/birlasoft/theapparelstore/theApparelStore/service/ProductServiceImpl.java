package com.birlasoft.theapparelstore.theApparelStore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birlasoft.theapparelstore.theApparelStore.daos.ProductDAO;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO dao;

	

	@Override
	public void addProduct(String name, double price, List<String> categories, String description, String stock,
			String imagepath1, String imagepath2, String imagepath3) {
		// TODO Auto-generated method stub
		Product product= new Product(name, price, categories, description, stock, imagepath1, imagepath2, imagepath3);
		dao.save(product);
		
	}



	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}



	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Optional<Product> optional= dao.findById(id);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}



	@Override
	public void removeProduct(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}



	@Override
	public void UpdateProduct(Product product, int id) {
		// TODO Auto-generated method stub
		
		Optional<Product> optional= dao.findById(id);
		if(optional.isPresent())
		{	
		product.setId(id);
		dao.save(product);
					
		}
		
	}



	@Override
	public void UpdateProductByQuery(int id, String name, double price, String description, String stock) {
		// TODO Auto-generated method stub
		
		dao.updatebyid(id, name, price, description, stock);
		
		
	}



	@Override
	public List<Product> getProductsBysearch(String search) {
		// TODO Auto-generated method stub
		return dao.searchproduct(search);
	}
	

	
	

}
