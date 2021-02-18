package com.birlasoft.theapparelstore.theApparelStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Customer;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Response;
import com.birlasoft.theapparelstore.theApparelStore.service.CustomerService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class CustomerController {
	
	@Autowired
	CustomerService service;
	
	@PostMapping("/addCustomer")
	public Response addCustomer(@RequestParam String email,@RequestParam String password, @RequestParam String full_name,
								@RequestParam String shipping_address, @RequestParam String country, @RequestParam String phone	)
	{
		try {
		Customer customer= new Customer(email, password,full_name, shipping_address, country, phone);	
		service.addCustomer(customer);
		return new Response("Ok", 200, "Customer Registered Successfully");
		
		
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
		
}
	@GetMapping("/authenticateCustomer/{email}/{password}")
	public Response CustomerLogin(@PathVariable String email,@PathVariable String password)
	{
		try {
			Customer customer= service.CustomerAuntheticate(email, password);
			if(customer!=null)
			{
				return new Response("Ok", 200, customer);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new Response("Failed", 200, null) ;
		
	}
	
	@GetMapping("/customer/profile/{email}")
	public Response getCustomer(@PathVariable String email)
	{
		try {
			
			Customer customer= service.getcustomer(email);
			if(customer!=null)
			{
				return new Response("Ok", 200, customer);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new Response("Not Found", 200, null);
	}
	
	@PutMapping("/profile/changePassword/{email}")
	public Response updatePassword(@PathVariable String email,@RequestParam String password)
	{
		try {
				service.updatepassword(email, password);
				return new Response("Ok", 200, "Password Changed");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new Response(null,200, null);
	}
		
	@PutMapping("/profile/changeAddress/{email}")
	public Response updateaddress(@PathVariable String email,@RequestParam String address)
	{
		try {
				service.updateaddress(email, address);
				return new Response("Ok", 200, "Address Changed");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return new Response(null,200, null);
	}

	
}