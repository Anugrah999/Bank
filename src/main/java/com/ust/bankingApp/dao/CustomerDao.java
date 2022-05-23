package com.ust.bankingApp.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.ust.bankingApp.entity.Customers;
import com.ust.bankingApp.response.CustomerBalanceResponse;

public interface CustomerDao {

//	public List<CustomerBalanceResponse> getCustomerBalance(); 
	
	public List<CustomerBalanceResponse> getCustomerBalanceById( int customerId); 
	


}
