package com.example.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Roles;
import com.example.model.User;
import com.example.repository.RolesRepository;
import com.example.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	 
	@Autowired
	RolesRepository rolesRepository;
	
	@Autowired
	UserService userService;
	
	public void save(User user) {
		Optional<Roles> role = rolesRepository.findById(1);
	    Roles roles = role.get();
	    HashSet<Roles> hashSet = new HashSet<>();
	    hashSet.add(roles);
		user.setRoles(hashSet);
		userRepository.save(user);	
	}

	public User update(User user,int id) {
		user.setId(id);
		return userRepository.save(user);	
	}

	public Optional<User> getById(int id) {
		
		return userRepository.findById(id);
	}

	public User getByName(String name) {
		
		return userRepository.findByName(name);
	}

}
