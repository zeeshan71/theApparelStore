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
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Product {
	@SequenceGenerator(name = "product_sequence_generator", 
						sequenceName = "product_sequence_generator",
						initialValue = 1, allocationSize = 1)
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_sequence_generator")
	private int id;
	
	@NotNull
	private String name;
	
	@NotNull
	private double price;
	
	@ElementCollection
	private List<String> categories;
	
	@NotNull
	@Column(length = 500)
	private String description;
	
	@NotNull
	private String stock;
	
	@Column(length = 200)
	private String image1;
	
	@Column(length = 200)
	private String image2;
	
	@Column(length = 200)
	private String image3;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="cart_id", nullable = true)
	private Cart cart;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String name, double price, List<String> categories, String description, String stock, String image1,
			String image2, String image3) {
		super();
		this.name = name;
		this.price = price;
		this.categories = categories;
		this.description = description;
		this.stock = stock;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		
	}
	/*public Product(Cart cart)
	{
		this.cart= cart;
	}*/
	

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
	public List<String> getCategories() {
		return categories;
	}




	public void setCategories(List<String> categories) {
		this.categories = categories;
	}




	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}


	/*public Cart getCart() {
		return cart;
	}*/

	/*public void setCart(Cart cart) {
		this.cart = cart;
	}*/


	/*@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", categories=" + categories
				+ ", description=" + description + ", stock=" + stock + ", image1=" + image1 + ", image2=" + image2
				+ ", image3=" + image3 + ", cart=" + cart + "]";
	}
*/
	



	


	

	

	
	
	
	
	
	
}
