package com.ust.bankingApp.response;

public class AccountDetailResponse {

	private int customerId;
	private String name;
	private String email;
	private int accId;
	public AccountDetailResponse() {
		super();
		
	}
	public AccountDetailResponse(int customerId, String name, String email, int accId) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.accId = accId;
	}
	@Override
	public String toString() {
		return "AccountDetailResponse [customerId=" + customerId + ", name=" + name + ", email=" + email + ", accId="
				+ accId + "]";
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



}
