package com.birlasoft.theapparelstore.theApparelStore.service;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Admin;

public interface AdminService {
	
	
	public void addAdmin(Admin admin);
	
	public Admin adminAuthenticate(String email, String password);

}
