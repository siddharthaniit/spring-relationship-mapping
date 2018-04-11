package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Roles;

@Repository
public interface RolesRepository extends CrudRepository<Roles, Integer>{

}
