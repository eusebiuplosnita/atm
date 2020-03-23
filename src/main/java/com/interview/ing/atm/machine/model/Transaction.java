package com.interview.ing.atm.machine.model;

import java.time.Instant;

public class Transaction {
	
	private Integer id;

	private String type;
	
	private Double amount;
	
	private Instant date;
	
	private BankAccount bankAccount;

	public Transaction() {}
	
	public Transaction(String type, Double amount, Instant date) {
		this.setType(type);
		this.setDate(date);
		this.setAmount(amount);
	}
	
	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
}
