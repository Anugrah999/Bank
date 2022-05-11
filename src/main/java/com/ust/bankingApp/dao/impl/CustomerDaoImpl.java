package com.ust.bankingApp.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import com.ust.bankingApp.dao.CustomerDao;
import com.ust.bankingApp.dao.support.NamedParameterJdbcDaoSupportClass;
import com.ust.bankingApp.response.CustomerBalanceResponse;

@Repository
public class CustomerDaoImpl extends NamedParameterJdbcDaoSupportClass implements CustomerDao {

	@Override
	public List<CustomerBalanceResponse> getCustomerBalance() {
		List<CustomerBalanceResponse> customers= null;
		try {
			String query="select customer_id, name, email,acc_id, balance from customer join account on customer.customer_id=account.c_id where customer_id=1";
			customers=getNamedParameterJdbcTemplate().getJdbcOperations().query(query, new BeanPropertyRowMapper<CustomerBalanceResponse>(CustomerBalanceResponse.class));
		}catch(Exception ex) {
			ex.getStackTrace();
		}
		return customers;
	}



}
