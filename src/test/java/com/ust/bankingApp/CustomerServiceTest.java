package com.ust.bankingApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.ust.bankingApp.dao.CustomerDao;
import com.ust.bankingApp.entity.Customers;
import com.ust.bankingApp.repository.CustomerRepository;
import com.ust.bankingApp.service.CustomerService;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerDao customerDao;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void getAllCustomersTest() {
		when(customerRepository.findAll())
				.thenReturn(Stream
						.of(new Customers(1, "dummyName", "dummyemail.com", "456879568"),
								new Customers(2, "dummyName1", "dummyemail1.com", "456459568"))
						.collect(Collectors.toList()));

		assertEquals(2, customerService.getAllCustomers().size());
	}

	@Test
	public void addOrUpdateCustomerTest() {
		Customers customers = new Customers(3, "dummyName3", "dummyemail.com", "776879568");
		when(customerRepository.save(customers)).thenReturn(customers);
		assertEquals(customers, customerService.addOrUpdateCustomer(customers));
	}

	@Test
	public void getCustomerByIdTest() {

		Customers customer = new Customers(3, "dummyName3", "dummyemail.com", "776879568");
		int id = 3;
		Customers customer1 = new Customers(4, "dummyName4", "dummyemail.com", "776879568");
		int id1 = 4;
		customer.setCustomerId(id);
		customer1.setCustomerId(id1);
		customerRepository.save(customer);
		customerRepository.save(customer1);
		when(customerRepository.findById(id)).thenReturn(Optional.of(customer));
		assertEquals(id, customerService.getCustomerById(id).getCustomerId());
	}
	
//	@Test
//	public void deleteCustomerTest() {
//		
//	}
//	
//	
//	@Test
//	public void getCustomerBalanceByIdTest() {
//		
//	}
}
