package com.birlasoft.theapparelstore.theApparelStore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.birlasoft.theapparelstore.theApparelStore.daos.AdminDAO;
import com.birlasoft.theapparelstore.theApparelStore.pojos.Admin;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDAO dao;
	
	
	@Override
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		dao.save(admin);
		
	}


	@Override
	public Admin adminAuthenticate(String email, String password) {
		// TODO Auto-generated method stub
		return dao.adminAuthenticate(email, password);
	}

}
