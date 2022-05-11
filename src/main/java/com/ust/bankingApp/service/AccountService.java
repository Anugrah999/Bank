package com.ust.bankingApp.service;

import java.util.List;

import com.ust.bankingApp.entity.Accounts;
import com.ust.bankingApp.response.AccountDetailResponse;


public interface AccountService {

	public List<Accounts> getAllAccounts();
	public Accounts getAccountById(int accountId);
	public Accounts addOrUpdateAccount(Accounts account);
	public Accounts deleteAccount(int accountId) throws Exception;
	public List<Accounts> getAccountByBalanceGreater(int balance);
	
	public List<AccountDetailResponse> getAccountDetail();
}