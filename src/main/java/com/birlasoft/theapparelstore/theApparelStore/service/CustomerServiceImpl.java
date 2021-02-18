package com.birlasoft.theapparelstore.theApparelStore.service;

import java.util.Optional;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birlasoft.theapparelstore.theApparelStore.daos.CustomerDAO;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO dao;
	
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		dao.save(customer);
		
	}

	@Override
	public Customer CustomerAuntheticate(String email, String password) {
		// TODO Auto-generated method stub
		
		return dao.authenticate(email, password);
		
		
		/*Customer customer= new Customer();
		
		customer.setEmail(email);
		customer.setPassword(password);
		org.springframework.data.domain.Example<Customer> example= org.springframework.data.domain.Example.of(customer);
		Optional<Customer> optional= dao.findOne(example);
		if(optional.isPresent())
		{
			return optional.get();
		}
		return null;*/
	}

	@Override
	public Customer getcustomer(String email) {
		// TODO Auto-generated method stub
		return dao.getCustomer(email);
	}

	@Override
	public void updatepassword(String email, String password) {
		// TODO Auto-generated method stub
			 dao.updatePassword(email, password);
	}

	@Override
	public void updateaddress(String email, String address) {
		// TODO Auto-generated method stub
		dao.updateAddress(email, address);
	}

}
