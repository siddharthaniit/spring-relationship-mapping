package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Aadhar;
import com.example.service.AadharService;

@RestController
public class AadharController {

	@Autowired
	private AadharService aadharService;
	
	@RequestMapping(value="/save3/{id}",method=RequestMethod.POST)
	public String save(@RequestBody Aadhar aadhar,@PathVariable int id)
	{
		aadharService.save(aadhar,id);
		return "Success";
	}
	
	@RequestMapping(value="/update3/{id}",method=RequestMethod.PUT)
	public Aadhar update(@RequestBody Aadhar aadhar,@PathVariable int id)
	{
		return aadharService.update(aadhar,id);
	}
	
	@RequestMapping(value="/byid3/{id}",method=RequestMethod.GET)
	public Optional<Aadhar> getById(@PathVariable int id)
	{
		System.out.println(id);
		return aadharService.getById(id);
	}
	
	
}
