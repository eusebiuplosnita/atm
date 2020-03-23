package com.interview.ing.atm.machine.entities;

import java.time.Instant;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Cacheable(false)
@Table(name = "transactions")
public class TransactionEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name = "bank_account_id", referencedColumnName = "bank_account_id")
	@ManyToOne
	private BankAccountEntity bankAccount;

	@Column(name = "type")
	private String type;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "date")
	private Instant date;

	public TransactionEntity() {}
	
	public TransactionEntity(Integer id, BankAccountEntity bankAccount, String type, Double amount, Instant date) {
		this.setId(id);
		this.setBankAccount(bankAccount);
		this.setType(type);
		this.setDate(date);
		this.setAmount(amount);
	}
	
	public BankAccountEntity getBankAccount() {
		return this.bankAccount;
	}
	
	public void setBankAccount(BankAccountEntity bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
