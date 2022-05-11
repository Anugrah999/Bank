package com.ust.bankingApp.dao;

import java.util.List;

import com.ust.bankingApp.response.AccountDetailResponse;

public interface AccountDao {

	public List<AccountDetailResponse> getAccountDetail();
}
