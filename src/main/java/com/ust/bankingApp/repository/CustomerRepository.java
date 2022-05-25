package com.ust.bankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ust.bankingApp.entity.Customers;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {

}
