package com.birlasoft.theapparelstore.theApparelStore.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Orders;

public interface OrdersDAO extends JpaRepository<Orders, Integer> {
	
	@Query("Select orders FROM Orders orders where orders.email=:email")
	public List<Orders> getOrdersByEmail(@Param(value="email")String email);
	
	@Query("Delete  From Orders orders where orders.email=:email and orders.orderid=:orderid")
	public void DeleteOrder(@Param(value="email")String email,@Param(value="orderid") int orderid);
	
	@Transactional
	@Modifying
	@Query("UPDATE Orders orders SET orders.paymentmode=:paymentmode where orders.orderid=:orderid")
	public void UpdatePaymentMode(@Param(value="orderid")int orderid, @Param(value="paymentmode")String paymentmode);
}
