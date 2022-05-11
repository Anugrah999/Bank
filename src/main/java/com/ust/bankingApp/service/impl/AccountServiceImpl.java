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
		// TODO Auto-generated method stub
		return (List<Accounts>) accountRepository.findAll();
	}

	@Override
	public Accounts getAccountById(int accountId) {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountId).orElse(null);
	}

	@Override
	public Accounts addOrUpdateAccount(Accounts account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public Accounts deleteAccount(int accountId) throws Exception {
		Accounts deletedAccount=null;
		try {
			deletedAccount=accountRepository.findById(accountId).orElse(null);
			if(deletedAccount==null) {
				throw new Exception("account not available");
			}else {
				accountRepository.deleteById(accountId);
			}
		}catch(Exception ex) {
			throw ex;
		}
		return deletedAccount;
	}

	@Override
	public List<Accounts> getAccountByBalanceGreater(int balance) {
		
		return accountRepository.getAccountByBalanceGreater(balance);
	}

	@Override
	public List<AccountDetailResponse> getAccountDetail() {
		// TODO Auto-generated method stub
		return accountDao.getAccountDetail();
	}

}
