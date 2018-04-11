package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Company;
import com.example.model.Product;
import com.example.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CompanyService companyService;
		
	public void save(Product product, int id) {
		Optional<Company> com = companyService.getById(id);
		Company company = com.get();
		product.setCompany(company);
		productRepository.save(product);	
	}

	public Product update(Product product,int id,int id1) {
	   // Optional<Product> pro = productRepository.findById(id);
	 //   Product pro1 = pro.get();
		Optional<Company> com1 = companyService.getById(id1);
		Company company = com1.get();
		product.setCompany(company);
		return productRepository.save(product);	
	}

	public Optional<Product> getById(int id) {
		
		return productRepository.findById(id);
	}


}
