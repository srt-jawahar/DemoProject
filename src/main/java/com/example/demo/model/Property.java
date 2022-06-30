package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PROPERTY")
public class Property 
{
	@Id
	@SequenceGenerator(name = "GROUPAGENT_SEQ", sequenceName = "GROUPAGENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUPAGENT_SEQ")
	@Column(name="PROPERTYID")
	private Long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="RULES")
	private String rules;
	
	@Column(name="NUMBER")
	private int number;
	
	@Column(name = "PASSWORD")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
