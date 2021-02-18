package com.birlasoft.theapparelstore.theApparelStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Cart;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Product;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Response;
import com.birlasoft.theapparelstore.theApparelStore.service.CartService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class CartController {

	@Autowired
	CartService cartservice;
	
	@PostMapping("/products/addToCart/{id}/{email}")
	public Response addtoCart(@PathVariable int id, @PathVariable String email)
	{
		try {
			
			cartservice.addToCart(id, email);
			return new Response("Ok", 200, "Product Added to Cart");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		return  null;
		
	}
	
	@GetMapping("/mycart/{email}")
	public List<Cart> myCart(@PathVariable String email)
	{
		return cartservice.getCartbyEmail(email);
		
	}
	
	@DeleteMapping("/deletecartProduct/{cartid}")
	public Response deleteproductincart(@PathVariable int cartid)
	{
		try {
		cartservice.deleteproductincart(cartid);
		return new Response("Ok", 200, "Product Removed");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return  null;
		
	}
	
	@GetMapping("/mycart/total/{email}")
	public Response sumofPrices(@PathVariable String email)
	{
		try {
		 double price= cartservice.getTotalofPrice(email);
		 return new Response("Ok", 200, price );
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@DeleteMapping("/deleteCart/{email}")
	public Response deletecart(@PathVariable String email)
	{
		try {
			
				cartservice.deletecart(email);
				return new Response("Ok",200, "Cart Deleted");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
}
