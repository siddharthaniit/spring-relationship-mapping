package com.example.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Roles;
import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private UserRepository userRepository;

	public String login(User user) {
		String rolename = null;
		String name = user.getName();
		String address = user.getAddress();
		User user1 = userRepository.findByName(name);
		if(user1 != null)
		{
		String name1 = user1.getName();
		String address1 = user1.getAddress();
		 Set<Roles> roles = user1.getRoles(); 
	    for (Roles role : roles) {
	    	 rolename = role.getRole();   	
	    } 
		if(name1.equals(name1) && address.equals(address1)&&rolename.equals("USER"))
		{
			return "success & user";
		}
		else if(name1.equals(name1) && address.equals(address1)&&rolename.equals("ADMIN")){
			return "success & Admin";

		}
		else {
			return "wrong credential"; 
		}
		
		}
	   return "No record found";
	}

}
