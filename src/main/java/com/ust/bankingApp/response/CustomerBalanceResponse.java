package com.ust.bankingApp.response;

public class CustomerBalanceResponse {

	private int customerId;
	private String name;
	private String email;
	private int accId;
	private int balance;
	public CustomerBalanceResponse() {
		super();
	
	}
	public CustomerBalanceResponse(int customerId, String name, String email, int accId, int balance) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.accId = accId;
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "CustomerBalanceResponse [customerId=" + customerId + ", name=" + name + ", email=" + email + ", accId="
				+ accId + ", balance=" + balance + "]";
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	
}
