package com.interview.ing.atm.machine.model;

import java.util.List;

public class BankAccount {
	
	private Integer bankAccountId;
	
	private String ibanCode;
	
	private double balance;
	
	private List<Transaction> transactions;
	
	public BankAccount() {}
	
	public BankAccount(Integer id) {
		this.setBankAccountId(id);
	}
	
	public BankAccount(Integer id, String ibanCode, Double balance, List<Transaction> transactions) {
		this.setBankAccountId(id);
		this.setIbanCode(ibanCode);
		this.setBalance(balance);
		this.setTransactions(transactions);
	}

	public Integer getBankAccountId() {
		return this.bankAccountId;
	}
	
	public void setBankAccountId(Integer id) {
		this.bankAccountId = id;
	}
	
	public String getIbanCode() {
		return ibanCode;
	}

	public void setIbanCode(String ibanCode) {
		this.ibanCode = ibanCode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public List<Transaction> getTransactions() {
		return this.transactions;
	}
	
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
}
