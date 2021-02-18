package com.birlasoft.theapparelstore.theApparelStore.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Customer {
	
	@SequenceGenerator(name="customer_sequence_generator",
						sequenceName = "customer_sequence_generator",
						initialValue = 1, allocationSize = 1)
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence_generator")
	private int customer_id;
	
	@NotNull
	@Column(length = 200, unique = true)
	@NaturalId(mutable=false)
	private String email;
	
	@NotNull
	@Column(length=200)
	private String password;
	
	@NotNull
	@Column(length= 200)
	private String full_name;
	
	@NotNull
	@Column(length= 200)
	private String shipping_address;
	
	@NotNull
	private String country;


	@NotNull
	private String phone;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String email, String password, String full_name, String shipping_address, String country,
			String phone) {
		super();
		this.email = email;
		this.password = password;
		this.full_name = full_name;
		this.shipping_address = shipping_address;
		this.country = country;
		this.phone = phone;
		
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", email=" + email + ", password=" + password + ", full_name="
				+ full_name + ", shipping_address=" + shipping_address + ", country=" + country + ", phone=" + phone
				+ "]";
	}
	
	

}
