package com.example.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/save2",method=RequestMethod.POST)
	public String save(@RequestBody User user)
	{
		userService.save(user);
		return "Success";
	}
	
	@RequestMapping(value="/update2/{id}",method=RequestMethod.PUT)
	public User update(@RequestBody User user,@PathVariable int id)
	{
		return userService.update(user,id);
	}
	
	@RequestMapping(value="/byid2/{id}",method=RequestMethod.GET)
	public Optional<User> getById(@PathVariable int id)
	{
		System.out.println(id);
		return userService.getById(id);
	}
	
	@RequestMapping(value="/byname/{name}",method=RequestMethod.GET)
	public User getById(@PathVariable String name)
	{
		return userService.getByName(name);
	}
	
	

}
