package com.ust.bankingApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ust.bankingApp.entity.Customers;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Integer> {

	 
}
