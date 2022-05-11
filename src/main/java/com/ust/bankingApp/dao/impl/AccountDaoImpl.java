package com.ust.bankingApp.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.ust.bankingApp.dao.AccountDao;
import com.ust.bankingApp.dao.support.NamedParameterJdbcDaoSupportClass;
import com.ust.bankingApp.response.AccountDetailResponse;

@Repository
public class AccountDaoImpl extends NamedParameterJdbcDaoSupportClass implements AccountDao {

	@Override
	public List<AccountDetailResponse> getAccountDetail() {
		List<AccountDetailResponse> account=null;
		try {
			String query="select customer_id, name ,acc_id, email from customer join account on customer.customer_id=account.c_id where customer_id=1";
			account= getNamedParameterJdbcTemplate().getJdbcOperations().query(query, new BeanPropertyRowMapper<AccountDetailResponse>(AccountDetailResponse.class));
		}catch(Exception ex) {
			ex.getStackTrace();
		}
		return account;
	}

}
