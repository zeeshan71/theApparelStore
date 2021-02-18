package com.birlasoft.theapparelstore.theApparelStore.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.birlasoft.theapparelstore.theApparelStore.pojos.Admin;

@Repository
public interface AdminDAO extends JpaRepository<Admin, Integer> {

	@Query("Select admin From Admin admin where admin.email=:email and admin.password=:password")
	public Admin adminAuthenticate(@Param("email")String email,@Param("password") String password);
}
