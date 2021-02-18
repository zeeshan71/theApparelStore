package com.birlasoft.theapparelstore.theApparelStore.service;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);
	
	public Customer CustomerAuntheticate(String email, String password);
	
	public Customer getcustomer(String email);
	
	public void updatepassword(String email, String password);
	
	public void updateaddress(String email, String address);
	
}
