package com.ust.bankingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ust.bankingApp.entity.Accounts;

@Repository
public interface AccountRepository extends CrudRepository<Accounts, Integer> {

	@Query(value="select * from account where balance> :balance", nativeQuery = true)
	public List<Accounts> getAccountByBalanceGreater(@Param("balance") int balance);
}
