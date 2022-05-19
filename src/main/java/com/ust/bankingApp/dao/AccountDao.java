package com.ust.bankingApp.dao;

import java.util.List;

import com.ust.bankingApp.response.AccountDetailResponse;

public interface AccountDao {

	public List<AccountDetailResponse> getAccountDetail();
	
	public List<AccountDetailResponse> getAccountDetailById(int accountId);
	
	//public List<AccountDetailResponse> updateAccount(int accountId, int balance);
	public int updateAccount(int accountId, int balance);
}
