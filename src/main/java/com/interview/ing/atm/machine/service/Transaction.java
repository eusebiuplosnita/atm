package com.interview.ing.atm.machine.service;

import java.time.Instant;

public class Transaction {

	private String type;
	
	private Double amount;
	
	private Instant date;

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
}
