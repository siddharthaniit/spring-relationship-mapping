package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Company;
import com.example.service.CompanyService;

@RestController
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String save(@RequestBody Company company) throws Exception
	{
		
		companyService.save(company);
		return "Success";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	public Company update(@RequestBody Company company,@PathVariable int id)
	{
		return companyService.update(company,id);
	}
	
	@RequestMapping(value="/byid/{id}",method=RequestMethod.GET)
	public Optional<Company> getById(@PathVariable int id)
	{
		System.out.println(id);
		return companyService.getById(id);
	}
	@RequestMapping(value="/deleteid/{id}",method=RequestMethod.DELETE)
	public void deleteById(@PathVariable int id)
	{
		 companyService.deleteById(id);
		 
	}
	
	

}
