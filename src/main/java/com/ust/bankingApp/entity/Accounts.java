package com.ust.bankingApp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Accounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="acc_id")
	private int accId;
	
	@Column(name="c_id")
	private int cId;
	
	@Column(name="balance")
	private int balance;

	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Accounts(int accId, int cId, int balance) {
		super();
		this.accId = accId;
		this.cId = cId;
		this.balance = balance;
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Accounts [accId=" + accId + ", cId=" + cId + ", balance=" + balance + "]";
	}



	
}
