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
import com.ust.bankingApp.response.CustomerBalanceResponse;
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
		ResponseEntity<Object> res = customerController.getCustomerById(customerId);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(customerId, ((Customers) res.getBody()).getCustomerId());
	}

	@Test
	public void addTest() {
		customers = new Customers(10, "dummyName9", "dummyemail.com", "456879568");

		when(customerService.addCustomer(customers)).thenReturn(customers);
		ResponseEntity<Customers> res = customerController.addCustomer(customers);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(customers, res.getBody());

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void updateTest() {
		customers = new Customers(10, "dummyName9", "dummyemail.com", "456879568");
		int custId = 1;
		String name = "Anugrah";
		String email = "anu@gmail.com";
		String Phone = "9876578290";

	}

	@Test
	public void DeleteTest() {
		customers = new Customers(10, "dummyName9", "dummyemail.com", "456879568");
		int custId = 1;
		ResponseEntity<String> res = customerController.deleteCustomer(custId);

	}

	@Test
	public void getCustomerDetailByIdTest() {
		CustomerBalanceResponse custBalance = new CustomerBalanceResponse(1, "Anugrah", "anu@gmail.com", 1000, 40000);
		int id = 1;
		CustomerBalanceResponse custBalance1 = new CustomerBalanceResponse(2, "AnugrahS", "anu@gmail.com", 1000, 3000);
		int id1 = 2;
		custBalance.setCustomerId(id1);
		custBalance1.setCustomerId(id);

	}
}
