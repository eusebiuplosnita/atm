package com.interview.ing.atm.machine.dtos;

import java.time.Instant;

public class TransactionDto {

	private Integer id;

	private String type;
	
	private Double amount;
	
	private Instant date;

	public TransactionDto(String type, Double amount, Instant date) {
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
}
