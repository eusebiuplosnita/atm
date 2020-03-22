package com.interview.ing.atm.machine.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cards")
public class CardEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "bankAccountId")
	private BankAccountEntity bankAccount;
	
	@Column(name = "owner")
	private String owner;
	
	private Instant expirationDate;
	
	public CardEntity() {}
	
	public CardEntity(Integer id, BankAccountEntity bankAccount, String owner, Instant expirationDate) {
		this.setId(id);
		this.setBankAccount(bankAccount);
		this.setExpirationDate(expirationDate);
		this.setOwner(owner);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BankAccountEntity getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccountEntity bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Instant getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Instant expirationDate) {
		this.expirationDate = expirationDate;
	}
}
