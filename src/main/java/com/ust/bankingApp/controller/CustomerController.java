package com.ust.bankingApp.controller;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ust.bankingApp.entity.Customers;
import com.ust.bankingApp.response.AccountDetailResponse;
import com.ust.bankingApp.response.CustomerBalanceResponse;
import com.ust.bankingApp.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customers>> getAllCustomers() {
		log.info("inside view all customer method");
		List<Customers> customers = null;
		customers = customerService.getAllCustomers();
		log.info("displayed all customers");
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getCustomerById(@PathVariable("id") int customerId) {
		log.info("inside view customer by Id method");
		Customers customers = customerService.getCustomerById(customerId);

		if (Objects.nonNull(customers)) {
			log.info("displayed customer details with customer id as {}", customerId);
			return new ResponseEntity<Object>(customers, HttpStatus.OK);
		} else {
			log.info("customer not found");
			return new ResponseEntity<Object>("customer not found", HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/add") // rename mthd
	public ResponseEntity<Customers> addCustomer(@RequestBody Customers customer) {
		log.info("inside add customer method");
		Customers customers = null;
		customers = customerService.addCustomer(customer);
		log.info("new customer added");
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Customers customer) {
		log.info("inside update customer method");
		Customers customers = customerService.getCustomerById(id);
		if (Objects.nonNull(customers)) {
			customer.setCustomerId(id);
			customers = customerService.addCustomer(customer);
			log.info("customer updated with customer Id as {}", id);
		} else {
			log.info("customer not found");
			return new ResponseEntity<Object>("customer not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(customers, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}") 
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int customerId) {
		log.info("inside delete customer method");
		boolean customers = false;
		try {
			customers = customerService.deleteCustomer(customerId);
			log.info("customer deleted with customer Id {}", customerId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		if (customers == true)
			return new ResponseEntity<String>("Customer deleted", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Customer could not be deleted", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/customerDetailById/{id}") 
	public ResponseEntity<List<CustomerBalanceResponse>> getCustomerDetailById(@PathVariable("id") int customerId) {
		log.info("inside view all details of customer method");
		List<CustomerBalanceResponse> customers = customerService.getCustomerDetailById(customerId);
		
		if(Objects.nonNull(customers) && !customers.isEmpty()) {
		log.info("displayed customer balance with customer id as {}", customerId);
		return new ResponseEntity<List<CustomerBalanceResponse>>(customers, HttpStatus.OK);
		}
		else {
			log.info("account not found");
			return new ResponseEntity<List<CustomerBalanceResponse>>(customers, HttpStatus.NOT_FOUND);
		}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
