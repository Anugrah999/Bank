package com.ust.bankingApp.response;

public class CustomerBalanceResponse {

	private int customer_id;
	private String name;
	private String email;
	private int acc_id;
	private int balance;

	public CustomerBalanceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerBalanceResponse(int customer_id, String name, String email, int acc_id, int balance) {
		super();
		this.customer_id = customer_id;
		this.name = name;
		this.email = email;
		this.acc_id = acc_id;
		this.balance = balance;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public int getAcc_id() {
		return acc_id;
	}

	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CustomerBalanceResponse [customer_id=" + customer_id + ", name=" + name + ", email=" + email
				+ ", acc_id=" + acc_id + ", balance=" + balance + "]";
	}

}
