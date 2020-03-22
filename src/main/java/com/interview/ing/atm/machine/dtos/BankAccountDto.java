package com.interview.ing.atm.machine.dtos;

import java.util.List;

public class BankAccountDto {
	
	private Integer bankAccountId;
	
	private String ibanCode;
	
	private double balance;
	
	private List<TransactionDto> transactions;
	
	public BankAccountDto() {}
	
	public BankAccountDto(Integer id) {
		this.setBankAccountId(id);
	}
	
	public BankAccountDto(Integer id, String ibanCode, Double balance, List<TransactionDto> transactions) {
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
	
	public List<TransactionDto> getTransactions() {
		return this.transactions;
	}
	
	public void setTransactions(List<TransactionDto> transactions) {
		this.transactions = transactions;
	}
}
