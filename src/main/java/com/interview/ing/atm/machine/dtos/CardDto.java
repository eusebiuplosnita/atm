package com.interview.ing.atm.machine.dtos;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardDto {

	private String cardId;
	
	private BankAccountDto bankAccount;
	
	private String owner;
	
	private Instant expirationDate;
	
	public CardDto() {}
	
	public CardDto(String id, BankAccountDto bankAccountDto, String owner, Instant expirationDate) {
		this.setCardId(id);
		this.setBankAccount(bankAccountDto);
		this.setExpirationDate(expirationDate);
		this.setOwner(owner);
	}
	
	public String getCardId() {
		return cardId;
	}

	public void setCardId(String id) {
		this.cardId = id;
	}

	public BankAccountDto getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccountDto bankAccount) {
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
