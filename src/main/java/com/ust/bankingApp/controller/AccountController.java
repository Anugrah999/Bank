package com.ust.bankingApp.controller;

import java.util.List;

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
import com.ust.bankingApp.entity.Accounts;
import com.ust.bankingApp.response.AccountDetailResponse;
import com.ust.bankingApp.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private static final Logger log = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private AccountService accountService;

	@GetMapping("/allAccounts")
	public ResponseEntity<List<Accounts>> getAllAccounts() {
		log.info("inside view all account method");
		List<Accounts> accounts = null;
		accounts = accountService.getAllAccounts();
		log.info("displayed all accounts");
		return new ResponseEntity<List<Accounts>>(accounts, HttpStatus.OK);
	}

	@GetMapping("/getById/{id}") // check condition
	public ResponseEntity<Accounts> getAccountById(@PathVariable("id") int accountId) {
		log.info("inside view account by Id method");
		Accounts accounts = null;

		accounts = accountService.getAccountById(accountId);
		log.info("displayed account details with account id as {}", accountId);
		return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
	}

	@PostMapping("/add") // rename mthd
	public ResponseEntity<Accounts> addOrUpdate(@RequestBody Accounts account) {
		log.info("inside add account method");
		Accounts accounts = null;
		accounts = accountService.addOrUpdateAccount(account);
		log.info("new account added");
		return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
	}

	@PostMapping("/update/{id}") // updateBalance and check for account available or not
	public ResponseEntity<String> updateAccount(@PathVariable int id, @RequestBody String balance) {
		log.info("inside update account method");
		var accounts = accountService.updateAccount(id, Integer.parseInt(balance));
		log.info("account balance updated with account Id as {}", id);
		if (accounts == 1)
			return new ResponseEntity<String>("Balance Updated", HttpStatus.OK);
		else 
			return new ResponseEntity<String>("Balance could not be updated", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/{id}") // mthd name
	public ResponseEntity<Accounts> addOrUpdate(@PathVariable("id") int accountId) {
		log.info("inside delete account method");
		Accounts accounts = null;
		try {
			accounts = accountService.deleteAccount(accountId);
			log.info("account deleted with account Id {}", accountId);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
	}

	@GetMapping("/allAccountsByBalanceGreater/{balance}") // rename method
	public ResponseEntity<List<Accounts>> getAallAccountsByBalanceGreater(@PathVariable("balance") int balance) {
		List<Accounts> accounts = null;
		accounts = accountService.getAccountByBalanceGreater(balance);
		return new ResponseEntity<List<Accounts>>(accounts, HttpStatus.OK);
	}

	@GetMapping("/accountDetailById/{id}") // rename method and check cond
	public ResponseEntity<List<AccountDetailResponse>> getAccountDetail(@PathVariable("id") int accountId) {
		log.info("inside view all details of account method");
		List<AccountDetailResponse> accounts = null;
		accounts = accountService.getAccountDetailById(accountId);
		log.info("displayed account details with customer id as {}", accountId);
		return new ResponseEntity<List<AccountDetailResponse>>(accounts, HttpStatus.OK);
	}
}