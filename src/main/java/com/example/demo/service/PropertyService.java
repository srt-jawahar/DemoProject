package com.example.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PropertyIdNotFoundException;
import com.example.demo.model.Property;
import com.example.demo.repository.PropertyRepository;

@Service
public class PropertyService 
{
	@Autowired
	private PropertyRepository propertyRepository;
	
	public ResponseEntity<?> createorUpdateProperty(Property property, HttpServletRequest http)
	{
		try
		{
			Long propertyId = property.getId();
			
			if(property.getId() != null)
			{
				Property proper = propertyRepository.findpropertyById(propertyId);
				
				if (proper == null)
				{
					return new ResponseEntity(HttpStatus.BAD_GATEWAY);
				}
			}
			
			propertyRepository.save(property);
			
		}
		catch(Exception e)
		{
			return new ResponseEntity("Not satisfied inputs",HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
		}
		
		return new ResponseEntity(property, HttpStatus.CREATED);
	}
	
	public ResponseEntity<?> getProperties(Long propertyid)
	{
		Property propertyL;
		try
		{
			propertyL = propertyRepository.findById(propertyid).orElseThrow(null);
		}
		catch(Exception e)
		{
			return new ResponseEntity("Id not found",HttpStatus.BAD_GATEWAY);
		}
		return new ResponseEntity(propertyL,HttpStatus.OK);
	}
}
