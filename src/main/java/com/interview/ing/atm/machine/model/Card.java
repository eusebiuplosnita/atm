package com.interview.ing.atm.machine.model;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cards")
public class Card {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@JoinColumn(name = "bankAccountId")
	@ManyToOne
	private BankAccount bankAccount;
	
	@Column(name = "owner")
	private String owner;
	
	private Instant expirationDate;
	
	public Card() {}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
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