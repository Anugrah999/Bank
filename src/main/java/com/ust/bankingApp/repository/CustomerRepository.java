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

	//@Query(value = "select customer.customer_id, customer.name, customer.email,account.acc_id, account.balance, customer.phone from customer join account on customer.customer_id=account.c_id where customer.customer_id= :customerId", nativeQuery = true)
	//@Query(value="select * from customer where customer_id= :customerId")
	public List<Customers> getCustomersByCustomerId(@Param("customerId") int customerId);
}
