package com.example.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer>{
	
	public Optional<Company> findById(int id);
}
