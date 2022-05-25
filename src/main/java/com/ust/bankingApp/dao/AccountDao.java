package com.ust.bankingApp.dao;

import java.util.List;

import com.ust.bankingApp.response.AccountDetailResponse;

public interface AccountDao {

	public List<AccountDetailResponse> getAccountDetailById(int accountId);

	public int updateAccountBalance(int accountId, int balance);

}
