package com.interview.ing.atm.machine.model;

import java.time.Instant;

public class Card {

	private Integer cardId;
	
	private BankAccount bankAccount;
	
	private String owner;
	
	private Instant expirationDate;
	
	public Card() {}
	
	public Card(Integer id, BankAccount bankAccount, String owner, Instant expirationDate) {
		this.setCardId(id);
		this.setBankAccount(bankAccount);
		this.setExpirationDate(expirationDate);
		this.setOwner(owner);
	}
	
	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer id) {
		this.cardId = id;
	}

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
