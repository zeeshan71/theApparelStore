package com.birlasoft.theapparelstore.theApparelStore.pojos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.sun.istack.NotNull;

@Entity
public class Orders {
	
	@SequenceGenerator(name = "order_sequence_generator", sequenceName = "order_sequence_generator",
						initialValue = 1, allocationSize = 1)
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence_generator")
	private int orderid;
	
	@NotNull
	private String email;
	
	@OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
	private List<Cart> cartitems;
	
	
	private String paymentmode;
	
	
	public Orders() {
		// TODO Auto-generated constructor stub
	}

	public Orders(String email, List<Cart> cartitems,String paymentmode) {
		super();
		this.email = email;
		this.cartitems = cartitems;
		this.paymentmode= paymentmode;
		
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Cart> getCartitems() {
		return cartitems;
	}

	public void setCartitems(List<Cart> cartitems) {
		this.cartitems = cartitems;
	}

	public String getPaymentmode() {
		return paymentmode;
	}

	public void setPaymentmode(String paymentmode) {
		this.paymentmode = paymentmode;
	}

		

}
