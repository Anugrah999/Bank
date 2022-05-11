package com.ust.bankingApp.dao.support;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

public class NamedParameterJdbcDaoSupportClass extends NamedParameterJdbcDaoSupport{

	@Autowired
	public void setDataSource3(DataSource dataSource) {
		setDataSource(dataSource);
	}
}
