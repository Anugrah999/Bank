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

		return (List<Customers>) customerRepository.findAll();
	}

	@Override
	public Customers getCustomerById(int customerId) {

		return customerRepository.findById(customerId).orElse(null);
	}

	@Override
	public Customers addOrUpdateCustomer(Customers customer) {
		return customerRepository.save(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) throws Exception {
		Customers deletedCustomer = null;
		
		try {
			deletedCustomer = customerRepository.findById(customerId).orElse(null);
			if (deletedCustomer == null) {
				throw new Exception("customer not available");
			} else {
				customerRepository.deleteById(customerId);
			}
		} catch (Exception ex) {
		
			return false;
		}
		return true;
	}

	@Override
	public List<CustomerBalanceResponse> getCustomerBalanceById(int customerId) {

		return customerDao.getCustomerBalanceById(customerId);

	}

}
