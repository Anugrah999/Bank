package com.ust.bankingApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ust.bankingApp.controller.CustomerController;
import com.ust.bankingApp.entity.Customers;
import com.ust.bankingApp.service.CustomerService;

@SpringBootTest
public class CustomerControllerTest {

	@Mock
	CustomerService customerService;

	@InjectMocks
	CustomerController customerController;

	List<Customers> mycustomers;
	Customers customers;

	@Test
	public void getAllCustomersTest() {

		mycustomers = new ArrayList<Customers>();
		mycustomers.add(new Customers(1, "dummyName", "dummyemail.com", "456879568"));
		mycustomers.add(new Customers(8, "dummyName8", "dummyemail.com", "456879568"));
		when(customerService.getAllCustomers()).thenReturn(mycustomers);
		ResponseEntity<List<Customers>> res = customerController.getAllCustomers();
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(2, res.getBody().size());
	}

	@Test
	public void getCustomerByIdTest() {
		customers = new Customers(9, "dummyName9", "dummyemail.com", "456879568");
		int customerId = 9;
		when(customerService.getCustomerById(customerId)).thenReturn(customers);
		ResponseEntity<Customers> res = customerController.getCustomerById(customerId);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(customerId, res.getBody().getCustomerId());
	}

	@Test
	public void addOrUpdateTest() {
		customers = new Customers(10, "dummyName9", "dummyemail.com", "456879568");

		when(customerService.addOrUpdateCustomer(customers)).thenReturn(customers);
		ResponseEntity<Customers> res = customerController.addOrUpdate(customers);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(customers, res.getBody());

	}
	
	
//	@Test
//	public void updateTest() {
//		
//		
//	}
//	
//	
//	@Test
//	public void addOrUpdateTestDelete() {
//		
//		
//	}
//	
//	
//	@Test
//	public void getCustomerDetailByIdTest() {
//		
//		
//	}
}
