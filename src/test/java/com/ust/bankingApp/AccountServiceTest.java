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
import com.ust.bankingApp.dao.AccountDao;
import com.ust.bankingApp.entity.Accounts;
import com.ust.bankingApp.repository.AccountRepository;
import com.ust.bankingApp.response.AccountDetailResponse;
import com.ust.bankingApp.service.AccountService;

@SpringBootTest
public class AccountServiceTest {

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
	public void addAccountTest() {
		Accounts accounts = new Accounts(1010, 600, 3);
		when(accountRepository.save(accounts)).thenReturn(accounts);
		assertEquals(accounts, accountService.addAccount(accounts));
	}

	@Test
	public void getAccountByIdTest() {

		Accounts account = new Accounts(1000, 5000, 1);
		int id = 1000;
		Accounts account1 = new Accounts(1002, 25000, 31);
		int id1 = 1002;
		account.setAccId(id);
		account1.setAccId(id1);
		accountRepository.save(account);
		accountRepository.save(account1);
		when(accountRepository.findById(id)).thenReturn(Optional.of(account));
		assertEquals(id, accountService.getAccountById(id).getAccId());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test
	public void deleteAccountTest() throws Exception {
		Accounts accounts = new Accounts(1010, 600, 3);

		int accID = 1010;
		accountService.deleteAccount(accID);

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
	public void updateAccountTest() {
		Accounts accounts = new Accounts(1010, 500, 3);
		int id = 1010;
	}

}
