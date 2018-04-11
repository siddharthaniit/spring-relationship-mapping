package com.example.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class Company {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@Fetch(FetchMode.JOIN)
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Product> products;
	
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
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
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Company() {
		super();
	}
	
	public Company(int id, String name, Set<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}
	
	
	
	
	

}
