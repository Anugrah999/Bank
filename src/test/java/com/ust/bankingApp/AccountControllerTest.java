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
import com.ust.bankingApp.response.AccountDetailResponse;
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
		ResponseEntity<Object> res = accountController.getAccountById(accountId);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(accountId, ((Accounts) res.getBody()).getAccId());
	}

	@Test
	public void getAccountDetailByCustomerIdTest() {

		AccountDetailResponse accDetail = new AccountDetailResponse(1, "Anugrah", "anu@gmail.com", 1000);
		int id = 1;
		AccountDetailResponse accDetail1 = new AccountDetailResponse(2, "AnugrahS", "anu@gmail.com", 1000);
		int id1 = 2;
		accDetail.setCustomerId(id);
		accDetail1.setCustomerId(id1);
		accDetail.setName("anugrah");
		accDetail.setEmail("anu@gmail.com");
		accDetail.setAccId(1000);
	}

	@Test
	public void addTest() {
		accounts = new Accounts(1070, 67809, 20);

		when(accountService.addAccount(accounts)).thenReturn(accounts);
		ResponseEntity<Accounts> res = accountController.addAccount(accounts);
		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(accounts, res.getBody());

	}

	@Test
	public void getAallAccountsByBalanceGreaterTest() {

		myaccounts = new ArrayList<Accounts>();
		myaccounts.add(new Accounts(1000, 5000, 1));
		myaccounts.add(new Accounts(1010, 51000, 12));
		when(accountService.getAccountByBalanceGreater(500)).thenReturn(myaccounts);
		ResponseEntity<List<Accounts>> res = accountController.getAllAccountsByBalanceGreater(500);
		assertEquals(HttpStatus.OK, res.getStatusCode());

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void updateTest() {
		accounts = new Accounts(1170, 67809, 20);
		int accountId = 1140;
		String balance = "100";

	}

	@Test
	public void DeleteTest() {

		accounts = new Accounts(1000, 678909, 2);
		int accountId = 1000;

		ResponseEntity<String> res = accountController.deleteAccount(accountId);

	}

}
