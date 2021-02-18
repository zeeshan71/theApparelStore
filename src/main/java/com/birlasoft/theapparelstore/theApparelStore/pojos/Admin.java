package com.birlasoft.theapparelstore.theApparelStore.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.sun.istack.NotNull;

@Entity
public class Admin {
	
	@SequenceGenerator(name = "admin_sequence_generator", sequenceName = "admin_sequence_generator",
						initialValue = 1, allocationSize = 1)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_sequence_generator")
	private int adminid;
	
	@NotNull
	private String full_name;
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(String full_name, String email, String password) {
		super();
		this.full_name = full_name;
		this.email = email;
		this.password = password;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", full_name=" + full_name + ", email=" + email + ", password=" + password
				+ "]";
	}
	
	
	
	

}
