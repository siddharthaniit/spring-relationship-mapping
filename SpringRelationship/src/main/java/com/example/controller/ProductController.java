package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;


	@RequestMapping(value = "/save1", method = RequestMethod.POST)
	public String save(@RequestBody Product product, @RequestParam int id) {
		productService.save(product,id);
		return "Success";
	}

	@RequestMapping(value = "/update1/{id}/{id1}", method = RequestMethod.PUT)
	public Product update(@RequestBody Product product, @PathVariable int id,@PathVariable int id1) {
		System.out.println(id);
		return productService.update(product, id,id1);
	}

	@RequestMapping(value = "/byid1/{id}", method = RequestMethod.GET)
	public Optional<Product> getById(@PathVariable int id) {
		return productService.getById(id);
	}

}
