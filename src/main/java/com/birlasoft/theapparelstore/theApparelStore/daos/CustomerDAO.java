package com.birlasoft.theapparelstore.theApparelStore.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	
	
	 
	
	@Query("Select customer from Customer customer where customer.email=:email and customer.password=:password")
	public Customer authenticate(@Param("email")String email,@Param("password") String password);
	
	@Query("Select customer from Customer customer where customer.email=:email")
	public Customer getCustomer(@Param(value="email")String email);
	
	@Transactional
	@Modifying
	@Query("UPDATE Customer customer SET customer.password=:password where customer.email=:email")
	public void updatePassword(@Param(value="email")String email, @Param(value="password")String password);
	
	@Transactional
	@Modifying
	@Query("UPDATE Customer customer SET customer.shipping_address=:address where customer.email=:email")
	public void updateAddress(@Param(value="email")String email, @Param(value="address")String address);
}
