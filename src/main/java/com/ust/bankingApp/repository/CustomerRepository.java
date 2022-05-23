package com.ust.bankingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ust.bankingApp.entity.Accounts;
import com.ust.bankingApp.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {

	
	//public List<Customers> getCustomersByCustomerId(@Param("customerId") int customerId);
}
