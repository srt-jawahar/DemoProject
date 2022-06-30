package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Property;
import com.example.demo.repository.PropertyRepository;
import com.example.demo.service.PropertyService;

@RestController
@RequestMapping("api/auth")
public class PropertyController 
{
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Autowired
	private PropertyService propertyService;
	
	@PostMapping("createorupdate")
	public ResponseEntity<?> createorupdate(@RequestBody Property property, HttpServletRequest http)
	{
		return ResponseEntity.status(HttpStatus.OK).body(propertyService.createorUpdateProperty(property, http));
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<?> getProprty(@PathVariable Long id,HttpServletRequest http)
	{
		return ResponseEntity.status(HttpStatus.OK).body(propertyService.getProperties(id));
		
	}
}
