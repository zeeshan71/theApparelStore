package com.birlasoft.theapparelstore.theApparelStore.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {
	
	@Query("Select cart  FROM Cart cart WHERE cart.email=:email")
	public List<Cart> getCartbyEmail(@Param(value = "email") String email);
	
	
	@Query("Select SUM(cart.price) FROM Cart cart where cart.email=:email")
	public double sumofPrice(String email);
	
	@Transactional
	@Modifying
	@Query("Delete  From Cart cart where cart.email=:email")
	public void deletecart(@Param(value="email")String email);
}
