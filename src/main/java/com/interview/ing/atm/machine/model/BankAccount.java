package com.interview.ing.atm.machine.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.interview.ing.atm.machine.service.Transaction;

@Entity
@Table(name="bankAccounts")
public class BankAccount {
	
	@Id
	@Column(name = "bankAccountId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankAccountId;
	
	@Column(name = "ibanCode")
	private String ibanCode;
	
	@Column(name = "balance")
	private double balance;
	
	@Transient
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
