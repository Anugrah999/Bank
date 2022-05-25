package com.ust.bankingApp.dao.impl;

import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ust.bankingApp.dao.AccountDao;
import com.ust.bankingApp.dao.support.NamedParameterJdbcDaoSupportClass;
import com.ust.bankingApp.response.AccountDetailResponse;

@Repository
public class AccountDaoImpl extends NamedParameterJdbcDaoSupportClass implements AccountDao {

	@Override
	public List<AccountDetailResponse> getAccountDetailById(int id) {
		List<AccountDetailResponse> account = null;
		try {
			String query = "select customer_id, name, email,acc_id from customer join account on customer.customer_id=account.c_id where customer_id= ?";
			account = getNamedParameterJdbcTemplate().getJdbcOperations().query(query, new Object[] { id },
					new BeanPropertyRowMapper<AccountDetailResponse>(AccountDetailResponse.class));
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		return account;
	}
 
	@Override

	public int updateAccountBalance(int accountId, int balance) {
		int accountUpdate=0;
		List<AccountDetailResponse> account = null;
		try {
			String query = "update account join customer on customer.customer_id=account.c_id set account.balance=:balance where acc_id= :accountId";
			SqlParameterSource paramSource = new MapSqlParameterSource().addValue("accountId", accountId)
					.addValue("balance", balance);

			 accountUpdate = getNamedParameterJdbcTemplate().update(query, paramSource);
		} catch (Exception ex) {
			ex.getStackTrace();
		}

		return accountUpdate;
	}

}
