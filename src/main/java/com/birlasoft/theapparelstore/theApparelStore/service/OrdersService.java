package com.birlasoft.theapparelstore.theApparelStore.service;

import java.util.List;


import com.birlasoft.theapparelstore.theApparelStore.pojos.Orders;

public interface OrdersService {

	public void createOrder(String email);
	
	public List<Orders> getOrdersbyEmail(String email);
	
	public void DeleteOrder(int orderid);
	
	public void setPaymentmode(int orderid, String paymentmode);
	
	public List<Orders> getOrders();
}
