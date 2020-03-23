package com.interview.ing.atm.machine.entities;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Cacheable(false)
@Table(name="bankAccounts")
public class BankAccountEntity {
	
	@Id
	@Column(name = "bank_account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bankAccountId;
	
	@Column(name = "iban_code")
	private String ibanCode;

	@Column(name = "balance")
	private double balance;

	@OneToMany(mappedBy = "bankAccount")
	private List<TransactionEntity> transactions;
	
	public BankAccountEntity() {}
	
	public BankAccountEntity(Integer id) {
		this.setBankAccountId(id);
	}
	
	public BankAccountEntity(Integer id, String ibanCode, Double balance) {
		this.setBankAccountId(id);
		this.setIbanCode(ibanCode);
		this.setBalance(balance);
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
}
