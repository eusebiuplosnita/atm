package com.interview.ing.atm.machine.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.ing.atm.machine.model.BankAccount;
import com.interview.ing.atm.machine.model.Card;
import com.interview.ing.atm.machine.model.Transaction;
import com.interview.ing.atm.machine.repository.BankAccountRepositoryImpl;
import com.interview.ing.atm.machine.repository.CardRepositoryImpl;

@Service("atmService")
public class AtmService {

	@Autowired
	private CardRepositoryImpl cardRepository;
	
	@Autowired 
	private BankAccountRepositoryImpl bankAccountRepository;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public Card insertCard(Card card) {
		if (card.getExpirationDate().compareTo(Instant.now()) < 1) {
			logger.warn("The inserted card is expired");
			throw new IllegalArgumentException("The card is expired");
		}

		if (cardRepository.findAll().iterator().hasNext()) {
			logger.warn("Cannot insert more than one card");
			throw new IllegalArgumentException("Cannot insert more than one card");
		}

		return cardRepository.save(card);
	}

	public void ejectCard(Integer cardId) {
		cardRepository.deleteById(cardId);
	}

	public BankAccount getAccountBalance(Integer cardId) {
		Card card = cardRepository.findById(cardId);
		if (card == null) {
			logger.warn("Card is not inserted");
			throw new NoSuchElementException("Please insert the card.");
		}

		BankAccount account = card.getBankAccount();
		
		//return only the transactions from the last 30 days.
		account.setTransactions(account.getTransactions().stream()
				.filter(t -> Instant.now().minus(30, ChronoUnit.DAYS).compareTo(t.getDate()) < 1)
				.collect(Collectors.toList()));
		return account;
	}

	public BankAccount executeTransaction(Integer cardId, Transaction transaction) {
		Card card = cardRepository.findById(cardId);
		if (card == null) {
			logger.warn("Card is not inserted");
			throw new NoSuchElementException("Please insert the card.");
		}
		
		if (transaction.getDate().compareTo(Instant.now()) > 1) {
			logger.warn("Invalid transaction date.");
			throw new IllegalArgumentException("Invalid transaction date.");
		}
		
		BankAccount bankAccount = card.getBankAccount();
		switch (transaction.getType()) {
			case "withdraw": {
					if (bankAccount.getBalance() - transaction.getAmount() < 0) {
						throw new IllegalArgumentException("Insufficient funds!");
					}
					bankAccount.setBalance(bankAccount.getBalance() - transaction.getAmount());
					return bankAccountRepository.save(bankAccount);
				} 
			case "deposit": {
					bankAccount.setBalance(bankAccount.getBalance() + transaction.getAmount());
					return bankAccountRepository.save(bankAccount);
				} 
			default: 
				throw new IllegalArgumentException("Transaction type not supported.");
		}
	}

}
