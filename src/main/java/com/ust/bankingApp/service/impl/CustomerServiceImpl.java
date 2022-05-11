package com.ust.bankingApp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.bankingApp.dao.CustomerDao;
import com.ust.bankingApp.entity.Customers;
import com.ust.bankingApp.repository.CustomerRepository;
import com.ust.bankingApp.response.CustomerBalanceResponse;
import com.ust.bankingApp.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<Customers> getAllCustomers() {
		// TODO Auto-generated method stub
		return (List<Customers>) customerRepository.findAll();
	}

	@Override
	public Customers getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public Customers addOrUpdateCustomer(Customers customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customers deleteCustomer(int customerId) throws Exception {
		Customers deletedCustomer=null;
		try {
			deletedCustomer =customerRepository.findById(customerId).orElse(null);
			if(deletedCustomer==null) {
				throw new Exception("customer not available");
			}else {
				customerRepository.deleteById(customerId);
			}
		}catch(Exception ex) {
			throw ex;
		}
		return null;
	}

	@Override
	public List<CustomerBalanceResponse> getCustomerBalance() {
		// TODO Auto-generated method stub
		return customerDao.getCustomerBalance();
	}

}
