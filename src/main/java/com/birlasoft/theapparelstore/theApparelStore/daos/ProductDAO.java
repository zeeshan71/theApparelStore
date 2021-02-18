package com.birlasoft.theapparelstore.theApparelStore.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{
	
	@Transactional
	@Modifying
	@Query("UPDATE Product product SET product.name=:name, product.price=:price, product.description=:description,product.stock=:stock where product.id=:id")
	public void updatebyid(@Param(value="id")int id,@Param(value="name")String name,@Param(value="price") double price,@Param(value="description") String description,@Param(value="stock") String stock );
	
	@Query("Select product from Product product where product.name like %:search%  OR product.description  like %:search% OR  product.price  like %:search%")
	public List<Product> searchproduct(@Param(value="search")String search);
}
