package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long>
{
	@Query(value="SELECT * FROM PROPERTY WHERE PROPERTYID=:id",nativeQuery = true)
	Property findpropertyById(@Param("id") Long id);
}
