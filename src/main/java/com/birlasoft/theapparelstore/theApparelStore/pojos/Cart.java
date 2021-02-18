package com.birlasoft.theapparelstore.theApparelStore.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Cart {

	@SequenceGenerator(name= "cart_sequence_generator", sequenceName = "cart_sequence_generator",
						initialValue = 1, allocationSize = 1)
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_sequence_generator")
	private int cartid;
	
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private  List<Product> products;
	
	@NotNull
	private int quantity=1;
	
	@NotNull
	private double price;
	
	@NotNull
	private String email;
	
	
	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn( nullable = true)
	private Orders orders;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	public Cart(List<Product> products, int quantity, double price, String email) {
		super();
		this.products = products;
		this.quantity = quantity;
		this.price = price;
		this.email = email;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
