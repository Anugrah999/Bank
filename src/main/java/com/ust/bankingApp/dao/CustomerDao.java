package com.ust.bankingApp.dao;

import java.util.List;

import com.ust.bankingApp.response.CustomerBalanceResponse;

public interface CustomerDao {

	public List<CustomerBalanceResponse> getCustomerBalance(); 
	

}
