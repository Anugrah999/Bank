package com.ust.bankingApp.controller;

import java.util.List;

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
import com.ust.bankingApp.response.CustomerBalanceResponse;
import com.ust.bankingApp.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomers")
	public ResponseEntity<List<Customers>> getAllCustomers(){
		List<Customers> customers=null;
		try {
			customers=customerService.getAllCustomers();
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<Customers>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Customers> getCustomerById(@PathVariable("id") int customerId){
		Customers customers=null;
		try {
			customers=customerService.getCustomerById(customerId);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	
	@PostMapping("/addOrUpdate")
	public ResponseEntity<Customers> addOrUpdate(@RequestBody Customers customer){
		Customers customers=null;
		try {
			customers=customerService.addOrUpdateCustomer(customer);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customers> addOrUpdate(@PathVariable("id") int customerId){
		Customers customers=null;
		try {
			customers=customerService.deleteCustomer(customerId);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Customers>(customers, HttpStatus.OK);
	}
	@GetMapping("/customerDetailById")
	public ResponseEntity<List<CustomerBalanceResponse>> getCustomerDetailById(){
		List<CustomerBalanceResponse> customers=null;
		try {
			customers=customerService.getCustomerBalance();
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<CustomerBalanceResponse>>(customers, HttpStatus.OK);
	}
	
}
