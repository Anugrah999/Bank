package com.ust.bankingApp.service;

import java.util.List;

import com.ust.bankingApp.entity.Customers;
import com.ust.bankingApp.response.CustomerBalanceResponse;

public interface CustomerService {

	public List<Customers> getAllCustomers();
	public Customers getCustomerById(int customerId);
	public Customers addOrUpdateCustomer(Customers customer);
	public Customers deleteCustomer(int customerId) throws Exception;
	
	public List<CustomerBalanceResponse> getCustomerBalance();
}
