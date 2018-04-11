package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.exception.RecordNotFound;
import com.example.model.Company;
import com.example.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	public void save(Company company) throws Exception {
		companyRepository.save(company);
	}

	public Company update(Company company, int id) {
		company.setId(id);
		return companyRepository.save(company);
	}

	public Optional<Company> getById(int id) {

		Optional<Company> findById = companyRepository.findById(id);
		if (!findById.isPresent())
			throw new RecordNotFound("record not found  " + id);
		return findById;
	}

	public void deleteById(int id) {

		try {
			companyRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecordNotFound("no record found "+id);
		}

	}

}
