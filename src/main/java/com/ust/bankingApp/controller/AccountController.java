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


	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getAccountById(@PathVariable("id") int accountId) {
		log.info("inside view account by Id method");
		Accounts accounts = accountService.getAccountById(accountId);

		if (Objects.nonNull(accounts)) {
			log.info("displayed account details with account id as {}", accountId);
			return new ResponseEntity<Object>(accounts, HttpStatus.OK);
		} else {
			log.info("account not found");
			return new ResponseEntity<Object>("account not found", HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/add")
	public ResponseEntity<Accounts> addAccount(@RequestBody Accounts account) {
		log.info("inside add account method");
		Accounts accounts = null;
		accounts = accountService.addAccount(account);
		log.info("new account added");
		return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
	}

	@PostMapping("/update/{id}")
	public ResponseEntity<String> updateAccountBalance(@PathVariable int id, @RequestBody String balance) {
		log.info("inside update account method");
		var accounts = accountService.updateAccountBalance(id, Integer.parseInt(balance));
		log.info("account balance updated with account Id as {}", id);
		if (accounts == 1)
			return new ResponseEntity<String>("Balance Updated", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Balance could not be updated", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAccount(@PathVariable("id") int accountId) {
		log.info("inside delete account method");
		boolean accounts = false;
		try {
			accounts = accountService.deleteAccount(accountId);

		} catch (Exception ex) {
			ex.getMessage();
		}
		if (accounts == true) {
			log.info("account deleted with account Id {}", accountId);
			return new ResponseEntity<String>("Account deleted", HttpStatus.OK);
		} else {
			log.info("account not found with account Id {}", accountId);
			return new ResponseEntity<String>("Account could not be deleted", HttpStatus.BAD_REQUEST);
		}
	}
 
	@GetMapping("/allAccountsByBalanceGreater/{balance}")
	public ResponseEntity<List<Accounts>> getAllAccountsByBalanceGreater(@PathVariable("balance") int balance) {
		List<Accounts> accounts = null;
		accounts = accountService.getAccountByBalanceGreater(balance);
		return new ResponseEntity<List<Accounts>>(accounts, HttpStatus.OK);
	}

	@GetMapping("/accountDetailById/{id}") // check cond
	public ResponseEntity<List<AccountDetailResponse>> getAccountDetails(@PathVariable("id") int accountId) {
		log.info("inside view all details of account method");
		List<AccountDetailResponse> accounts = null;
		accounts = accountService.getAccountDetailById(accountId);
		log.info("displayed account details with customer id as {}", accountId);
		return new ResponseEntity<List<AccountDetailResponse>>(accounts, HttpStatus.OK);
	}

//	@GetMapping("/accountDetailById/{id}") // check cond
//	public ResponseEntity<Object<AccountDetailResponse>> getAccountDetails(@PathVariable("id") int accountId) {
//		log.info("inside view all details of account method");
//		List<AccountDetailResponse> accounts =  accountService.getAccountDetailById(accountId);
//		
//		if(Objects.nonNull(accounts)) {
//			log.info("displayed account details with customer id as {}", accountId);
//			return new ResponseEntity<Object<AccountDetailResponse>>(accounts, HttpStatus.OK);	
//		}
//		else {
//			log.info("account not found");
//			return new ResponseEntity<Object<AccountDetailResponse>>("account not found", HttpStatus.NOT_FOUND);
//		}
	
//	}

}