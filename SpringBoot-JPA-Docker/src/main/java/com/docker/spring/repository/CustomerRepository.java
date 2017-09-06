package com.docker.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docker.spring.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{

	//@Query('SELECT ')
	public List<Customer> findByLastNameContaining(String name);
	public List<Customer> findByFirstNameContaining(String name);

}
