package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Aadhar;
import com.example.model.User;
import com.example.repository.AadharRepository;

@Service
public class AadharService {
	@Autowired
	private AadharRepository aadharRepository;
	
	@Autowired
	private UserService userService;
	
	public void save(Aadhar aadhar,int id) {
		Optional<User> user = userService.getById(id);
		User user1 = user.get();
		aadhar.setUser(user1);
		aadharRepository.save(aadhar);	
	}

	public Aadhar update(Aadhar aadhar,int id) {
		aadhar.setId(id);
		return aadharRepository.save(aadhar);	
	}

	public Optional<Aadhar> getById(int id) {
		
		return aadharRepository.findById(id);
	}

}
