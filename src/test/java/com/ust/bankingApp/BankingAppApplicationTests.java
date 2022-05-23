package com.ust.bankingApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ust.bankingApp.dao.AccountDao;
import com.ust.bankingApp.entity.Accounts;
import com.ust.bankingApp.repository.AccountRepository;
import com.ust.bankingApp.service.AccountService;

@SpringBootTest
class BankingAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private AccountService accountService;
	
	@MockBean
	private AccountDao accountDao;

	@MockBean
	private AccountRepository accountRepository;

	@Test
	public void getAllAccountsTest() {
		when(accountRepository.findAll()).thenReturn(
				Stream.of(new Accounts(1000, 8, 7000), new Accounts(1001, 5, 567)).collect(Collectors.toList()));

		assertEquals(2, accountService.getAllAccounts().size());
	}

	@Test
	public void getAccountByBalanceGreaterTest() {
		int balance = 600;
		when(accountRepository.getAccountByBalanceGreater(balance))
				.thenReturn(Stream.of(new Accounts(1002, 500, 9)).collect(Collectors.toList()));
		assertEquals(1, accountService.getAccountByBalanceGreater(balance).size());
	}

	@Test
	public void addOrUpdateAccountTest() {
		Accounts accounts = new Accounts(1010, 600, 3);
		when(accountRepository.save(accounts)).thenReturn(accounts);
		assertEquals(accounts, accountService.addOrUpdateAccount(accounts));
	}

//	@Test
//	public void deleteAccountTest() {
//		Accounts accounts = new Accounts(1010, 600, 3);
//		accountService.deleteAccount(3);
//		int accID=1000;
//		verify(accountRepository, times(1)).deleteById(accID);;
//		
//	}
	
//	@Test
//	public void getAccountByIdTest() {
//		List<Accounts> accounts=new ArrayList<Accounts>();
//		accounts.add(new Accounts(1000,5000,1));
//		accounts.add(new Accounts(1010,51000,12));
//		
//		int accountId=1000;
//		when(accountRepository.findById(accountId).orElse(null)).thenReturn(accounts);
//		
//		assertEquals(accountId, accountService.getAccountById(accountId).getAccId());
//	}
	
//	@Test
//	public void updateAccountTest() {
//		Accounts accounts = new Accounts(1010, 500, 3);
//		when(accountDao.updateAccount(1010, 500)).thenReturn(accounts);
//		assertEquals(accounts, accountDao.updateAccount(1010, 500));
//	}
	
	
	
	
	
	
	
	
}
