package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
	@Query(value = "SELECT * FROM USERDETAILS where id = :id",nativeQuery = true)
	Optional<User> findUser(@Param("id") long id);
	
	@Query(value = "SELECT * FROM USERDETAILS where USERDETAILS.name = 'sysadmin' order by USERDETAILS.userId ", nativeQuery = true)
	Optional<User> findFirstAdmin();
}
