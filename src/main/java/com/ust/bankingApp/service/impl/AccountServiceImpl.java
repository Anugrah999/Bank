package com.ust.bankingApp.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.bankingApp.dao.AccountDao;
import com.ust.bankingApp.entity.Accounts;

import com.ust.bankingApp.repository.AccountRepository;
import com.ust.bankingApp.response.AccountDetailResponse;
import com.ust.bankingApp.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountDao accountDao;

	@Override
	public List<Accounts> getAllAccounts() {

		return (List<Accounts>) accountRepository.findAll();
	}

	@Override
	public Accounts getAccountById(int accountId) {

		return accountRepository.findById(accountId).orElse(null);
	}



	@Override
	public Accounts addAccount(Accounts account) {

		return accountRepository.save(account);
	}

	@Override
	public boolean deleteAccount(int accountId) throws Exception {
		Accounts deletedAccount = null;
		try {
			deletedAccount = accountRepository.findById(accountId).orElse(null);
			if (deletedAccount == null) {
				throw new Exception("account not available");
			} else {
				accountRepository.deleteById(accountId);
			}
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public List<Accounts> getAccountByBalanceGreater(int balance) {

		return accountRepository.getAccountByBalanceGreater(balance);
	}
 
	@Override
	public List<AccountDetailResponse> getAccountDetailByCustomerId(int accId) {

		return accountDao.getAccountDetailById(accId);
	}

	@Override

	public int updateAccountBalance(int accountId, int balance) {

		return accountDao.updateAccountBalance(accountId, balance);
	}

}
