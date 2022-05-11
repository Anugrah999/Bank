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
import com.ust.bankingApp.entity.Accounts;
import com.ust.bankingApp.response.AccountDetailResponse;
import com.ust.bankingApp.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@GetMapping("/allAccounts")
	public ResponseEntity<List<Accounts>> getAllAccounts(){
		List<Accounts> accounts=null;
		try {
			accounts=accountService.getAllAccounts();
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<Accounts>>(accounts, HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Accounts> getAccountById(@PathVariable("id") int accountId){
		Accounts accounts=null;
		try {
			accounts=accountService.getAccountById(accountId);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
	}
	
	@PostMapping("/addOrUpdate")
	public ResponseEntity<Accounts> addOrUpdate(@RequestBody Accounts account){
		Accounts accounts=null;
		try {
			accounts=accountService.addOrUpdateAccount(account);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Accounts> addOrUpdate(@PathVariable("id") int accountId){
		Accounts accounts=null;
		try {
			accounts=accountService.deleteAccount(accountId);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
	}
	
	@GetMapping("/allAccountsByBalanceGreater/{balance}")
	public ResponseEntity<List<Accounts>> getAallAccountsByBalanceGreater(@PathVariable("balance") int balance){
		List<Accounts> accounts=null;
		try {
			accounts=accountService.getAccountByBalanceGreater(balance);
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<Accounts>>(accounts, HttpStatus.OK);
	}
	@GetMapping("/accountDetailsById")
	public ResponseEntity<List<AccountDetailResponse>> getAccountDetail(){
		List<AccountDetailResponse> accounts=null;
		try {
			accounts=accountService.getAccountDetail();
		}
		catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<AccountDetailResponse>>(accounts, HttpStatus.OK);
	}
}

