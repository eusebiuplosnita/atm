package com.interview.ing.atm.machine.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDto {

	private String id;
	
	private String bankAccount;
	
	private String owner;
	
	private Instant expirationDate;
	
	public CardDto() {}
	
	public CardDto(String id, String bankAccountId, String owner, Instant expirationDate) {
		this.setId(id);
		this.setBankAccount(bankAccountId);
		this.setExpirationDate(expirationDate);
		this.setOwner(owner);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccountId) {
		this.bankAccount = bankAccountId;
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
