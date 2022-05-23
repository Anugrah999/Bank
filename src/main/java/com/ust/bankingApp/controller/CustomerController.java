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
import com.ust.bankingApp.repository.CustomerRepository;
import com.ust.bankingApp.response.CustomerBalanceResponse;
import com.ust.bankingApp.service.CustomerService;
import com.ust.bankingApp.service.impl.CustomerServiceImpl;

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
		try {
			customers = customerService.getAllCustomers();
			log.info("displayed all customers");
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Customers> getCustomerById(@PathVariable("id") int customerId) {
		log.info("inside view customer by Id method");
		Customers customers = null;
		try {
			customers = customerService.getCustomerById(customerId);
			log.info("displayed customer details with customer id as {}", customerId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@PostMapping("/add")
	public ResponseEntity<Customers> addOrUpdate(@RequestBody Customers customer) {
		log.info("inside add customer method");
		Customers customers = null;
		try {
			customers = customerService.addOrUpdateCustomer(customer);
			log.info("new customer added");
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Customers customer) {
		log.info("inside update customer method");
		Customers customers = customerService.getCustomerById(id);
		try {
			if (Objects.nonNull(customers)) {
				customer.setCustomerId(id);
				customers = customerService.addOrUpdateCustomer(customer);
				log.info("customer updated with customer Id as {}", id);
			} else {
				log.info("customer not found");
				return new ResponseEntity<Object>("customer not found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			log.error("failed due to {} ", ex.getMessage());
		}
		return new ResponseEntity<Object>(customers, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customers> addOrUpdate(@PathVariable("id") int customerId) {
		log.info("inside delete customer method");
		Customers customers = null;
		try {
			customers = customerService.deleteCustomer(customerId);
			log.info("customer deleted with customer Id {}", customerId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}

// @GetMapping("/customerDetailById")
// public ResponseEntity<List<CustomerBalanceResponse>> getCustomerDetailById() {
//
// List<CustomerBalanceResponse> customers = null;
// try {
// customers = customerService.getCustomerBalance();
// } catch (Exception ex) {
// ex.getMessage();
// }
// return new ResponseEntity<List<CustomerBalanceResponse>>(customers, HttpStatus.OK);
// }

	@GetMapping("/customerDetailByIdDynamic/{id}")
	public ResponseEntity<List<CustomerBalanceResponse>> getCustomerDetailById(@PathVariable("id") int customerId) {
		log.info("inside view all details of customer method");
		List<CustomerBalanceResponse> customers = null;
		try {
			customers = customerService.getCustomerBalanceById(customerId);
			log.info("displayed customer balance with customer id as {}", customerId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<CustomerBalanceResponse>>(customers, HttpStatus.OK);
	}

}