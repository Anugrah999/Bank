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
import com.ust.bankingApp.controller.AccountController;
import com.ust.bankingApp.entity.Accounts;
import com.ust.bankingApp.service.AccountService;

@SpringBootTest(classes = { AccountControllerTest.class })
public class AccountControllerTest {

	@Mock
	AccountService accountService;

	@InjectMocks
	AccountController accountController;

	List<Accounts> myaccounts;
	Accounts accounts;

	@Test
	public void getAllAccountsTest() {

		myaccounts = new ArrayList<Accounts>();
		myaccounts.add(new Accounts(1000, 5000, 1));
		myaccounts.add(new Accounts(1010, 51000, 12));
		when(accountService.getAllAccounts()).thenReturn(myaccounts);
		ResponseEntity<List<Accounts>> res = accountController.getAllAccounts();
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(2, res.getBody().size());
	}

	@Test
	public void getAccountByIdTest() {
		accounts = new Accounts(1000, 678909, 2);
		int accountId = 1000;
		when(accountService.getAccountById(accountId)).thenReturn(accounts);
		ResponseEntity<Accounts> res = accountController.getAccountById(accountId);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(accountId, res.getBody().getAccId());
	}

	@Test
	public void addOrUpdateTest() {
		accounts = new Accounts(1070, 67809, 20);

		when(accountService.addOrUpdateAccount(accounts)).thenReturn(accounts);
		ResponseEntity<Accounts> res = accountController.addOrUpdate(accounts);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(accounts, res.getBody());

	}

//	@Test
//	public void updateTest() {
//		accounts = new Accounts(1170, 67809, 20);
//		int accountId=1140;
//		int balance=100;
//		when(accountService.updateAccount(accountId, balance)).thenReturn(accounts);
//		ResponseEntity<Accounts> res = accountController.updateAccount(accounts);
//		assertEquals(1, res.);
//		assertEquals(accounts, res.getBody());
//
//	}
//	

//	public void addOrUpdateTestDelete() {
//		
//		
//		accounts = new Accounts(1000, 678909, 2);
//		int accountId = 1000;
//		when(accountService.deleteAccount(accountId)).thenReturn(accounts);
//		
//		
//		
//		
//		
//		
//	}
	
	
//	
//	@Test
//	public void getAallAccountsByBalanceGreaterTest() {
//		
//		
//	}
//	
//	
//	
//	@Test
//	public void getAccountDetailTest() {
//		
//		
//	}

}
