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
@Table(name="cards")
public class CardEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_id")
	private Integer cardId;
	
	@JoinColumn(name = "bank_account_id",referencedColumnName="bank_account_id")
	@ManyToOne
	private BankAccountEntity bankAccount;
	
	@Column(name = "owner")
	private String owner;
	
	@Column(name="expiration_date")
	private Instant expirationDate;
	
	public CardEntity() {}
	
	public CardEntity(Integer id, BankAccountEntity bankAccount, String owner, Instant expirationDate) {
		this.setId(id);
		this.setBankAccount(bankAccount);
		this.setExpirationDate(expirationDate);
		this.setOwner(owner);
	}
	
	public Integer getId() {
		return cardId;
	}

	public void setId(Integer id) {
		this.cardId = id;
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
