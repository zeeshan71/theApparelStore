package com.birlasoft.theapparelstore.theApparelStore.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Product;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Response;
import com.birlasoft.theapparelstore.theApparelStore.service.ProductService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@PostMapping("/addProducts")
	public Response addProduct( @RequestParam("name")String name, @RequestParam("price")double price,
			@RequestParam("categories") List<String> categories,
			@RequestParam("description")String description,@RequestParam("stock")String stock,
			@RequestParam("image1") MultipartFile image1,
			@RequestParam("image2") MultipartFile image2, @RequestParam("image3") MultipartFile image3)
	{
		try 
		{
			File file= new File("D:/Web Development/Angular Projects/TheApparelStore/src/assets/images/products/"+name);
		
			if(!file.exists())
			{
				file.mkdir();
			}
			
			
			String imagepath1= "D:/Web Development/Angular Projects/TheApparelStore/src/assets/images/products/"+name+"/"+image1.getOriginalFilename();
			FileOutputStream fout1= new FileOutputStream(imagepath1);
			BufferedOutputStream bout1= new BufferedOutputStream(fout1);
		
			String imagepath2= "D:/Web Development/Angular Projects/TheApparelStore/src/assets/images/products/"+name+"/"+image2.getOriginalFilename();
			FileOutputStream fout2= new FileOutputStream(imagepath2);
			BufferedOutputStream bout2= new BufferedOutputStream(fout2);
		
			
			String imagepath3= "D:/Web Development/Angular Projects/TheApparelStore/src/assets/images/products/"+name+"/"+image3.getOriginalFilename();
			FileOutputStream fout3= new FileOutputStream(imagepath3);
			BufferedOutputStream bout3= new BufferedOutputStream(fout3);
		
		
				
			IOUtils.copy(image1.getInputStream(), bout1);
			IOUtils.copy(image2.getInputStream(), bout2);
			IOUtils.copy(image3.getInputStream(), bout3);
			
			service.addProduct(name, price, categories, description, stock, imagepath1, imagepath2, imagepath3);
			
				
			return new Response("Ok", 200, "Product Added");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/allProducts")
	public List<Product> getProducts()
	{
		return service.getProducts();
		
	}
	
	@GetMapping("/searchproducts/{search}")
	public List<Product> getProductsBysearch(@PathVariable String search)
	{
		return service.getProductsBysearch(search);
	}
	
	
	
	

	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable int id)
	{
		try {
			return service.getProduct(id);
		}
	catch(Exception e)
		{
			return null;
		}
	}
	
	@PutMapping("/product/update/{id}")
	public String UpdateProduct( @PathVariable int id, @RequestBody Product product)
	{
		
		try {
		
			service.UpdateProduct(product, id);
			return "Product Updated Successfully";
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return "Product was not Updated";
	}
	
	@GetMapping(value="/product/image1/{id}", produces= {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public byte[] getImage1(@PathVariable int id)
	{
		try {
			Product product= service.getProduct(id);
			
			if(product!=null)
			{
				FileInputStream fin1= new FileInputStream(product.getImage1());
				BufferedInputStream bin1= new BufferedInputStream(fin1);
				return IOUtils.toByteArray(bin1);
			}
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	@GetMapping(value="/product/image2/{id}", produces= {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public byte[] getImage2(@PathVariable int id)
	{
		try {
			Product product= service.getProduct(id);
			
			if(product!=null)
			{
				FileInputStream fin2= new FileInputStream(product.getImage2());
				BufferedInputStream bin2= new BufferedInputStream(fin2);
				return IOUtils.toByteArray(bin2);
			}
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
		
	}
	@GetMapping(value="/product/image3/{id}", produces= {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
	public byte[] getImage3(@PathVariable int id)
	{
		try {
			Product product= service.getProduct(id);
			
			if(product!=null)
			{
				FileInputStream fin3= new FileInputStream(product.getImage3());
				BufferedInputStream bin3= new BufferedInputStream(fin3);
				return IOUtils.toByteArray(bin3);
			}
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
					
	}
	@DeleteMapping("/removeProduct/{id}")
	public Response removeProduct(@PathVariable int id)
	{
		service.removeProduct(id);
		return new Response("OK", 200, "Product Deleted");
	}
	
	@PutMapping("/product/updatebyquery/{id}")
	public Response UpdateProductbyquery( @PathVariable int id, @RequestParam String name, @RequestParam double price, @RequestParam String description, @RequestParam String stock)
	{
		try {
		service.UpdateProductByQuery(id, name, price, description, stock);
		return new Response("Updated", 200, "Product Updated Successfully");
		}
	catch(Exception e)
		{
			e.printStackTrace();
		}
		return new Response("Not Updated", 200, null);
	}
}
