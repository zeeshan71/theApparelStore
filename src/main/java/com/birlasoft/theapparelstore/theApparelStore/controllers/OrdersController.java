package com.birlasoft.theapparelstore.theApparelStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Orders;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Response;
import com.birlasoft.theapparelstore.theApparelStore.service.OrdersService;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class OrdersController {
	
	@Autowired
	OrdersService service;
	
	@PostMapping("/orders/newOrder/{email}")
	public Response createOrder(@PathVariable String email)
	{
		try {
			service.createOrder(email);
			return new Response("Ok", 200, "Order Placed");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return  null;
		
	}
	
	
	@GetMapping("/myOrders/{email}")
	public List<Orders> myOrders(@PathVariable String email)
	{
		return service.getOrdersbyEmail(email);
	}
	
	@DeleteMapping("/myOrder/Delete/{orderid}")
	public Response DeleteOrder(@PathVariable int orderid )
	{
		try {
			
				service.DeleteOrder(orderid);
				return new Response("Ok",200,"Order was Cancelled");
	}
	catch(Exception e)
		{
		e.printStackTrace();
		}
		return new Response("Ok",200,"Order was not Cancelled");
	}
	
	@PutMapping("/orders/paymentmode/{orderid}")
	public Response setPaymentMode(@PathVariable int orderid, @RequestParam String paymentmode)
	{
		try {
			service.setPaymentmode(orderid, paymentmode);
			return new Response("Ok", 200, "Payment Mode Set");
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
		return null;
		
	}
	
	@GetMapping("/orders/allorders")
	public List<Orders> getorders()
	{
		return service.getOrders();
	}
	


		
}
