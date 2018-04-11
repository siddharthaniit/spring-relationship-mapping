package com.example.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private int id;
	
	//@Column(updatable =  false)
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name= "company_id")
	@JsonBackReference
	private Company company;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
	

	public Product() {
		super();
	}

	public Product(int id, String name, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
	
	
	
	

}
