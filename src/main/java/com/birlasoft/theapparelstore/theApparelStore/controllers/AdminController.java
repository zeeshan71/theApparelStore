package com.birlasoft.theapparelstore.theApparelStore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Admin;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Response;
import com.birlasoft.theapparelstore.theApparelStore.service.AdminService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class AdminController {

	@Autowired
	AdminService service;
	
	@PostMapping("/addAdmin")
	public String addAdmin(@RequestBody Admin admin)
	{
		try {
			service.addAdmin(admin);
			return "Admin Added Successfully";
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Admin was not added";
		
	}
	
	@GetMapping("/authenticateAdmin/{email}/{password}")
	public Response adminAuthenticate(@PathVariable String email, @PathVariable String password)
	{
		try {
			Admin admin=service.adminAuthenticate(email, password);
			if(admin!=null)
			{
				return new Response("Ok", 200,admin);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return new Response("Not Ok", 200, null);
		
	}
	
}
