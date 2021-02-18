package com.birlasoft.theapparelstore.theApparelStore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birlasoft.theapparelstore.theApparelStore.daos.CartDAO;
import com.birlasoft.theapparelstore.theApparelStore.daos.OrdersDAO;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Cart;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Orders;

@Service
public class OrderServiceImpl implements OrdersService {

	@Autowired
	CartDAO cartdao;
	
	@Autowired
	OrdersDAO ordersdao;
	
	@Override
	public void createOrder(String email) {
		// TODO Auto-generated method stub
			List<Cart> cartitems= cartdao.getCartbyEmail(email);
			
			Orders orders= new Orders();
			
			orders.setCartitems(cartitems);
			orders.setEmail(email);
			
			ordersdao.save(orders);
			
			
			
	}

	@Override
	public List<Orders> getOrdersbyEmail(String email) {
		// TODO Auto-generated method stub
		return ordersdao.getOrdersByEmail(email);
	}

	@Override
	public void DeleteOrder(int orderid) {
		// TODO Auto-generated method stub
		
		Optional<Orders> optional= ordersdao.findById(orderid);
		if(optional.isPresent())
		{
			ordersdao.deleteById(orderid);
		}
		
	}
	
	public void setPaymentmode(int orderid, String paymentmode)
	{
		
		Optional<Orders> optional= ordersdao.findById(orderid);
		if(optional.isPresent())
		{
			ordersdao.UpdatePaymentMode(orderid, paymentmode);
		}
		
	}

	@Override
	public List<Orders> getOrders() {
		// TODO Auto-generated method stub
		return ordersdao.findAll();
	}
}
