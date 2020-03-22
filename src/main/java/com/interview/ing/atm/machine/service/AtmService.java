package com.interview.ing.atm.machine.service;

import java.time.Instant;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.ing.atm.machine.model.BankAccount;
import com.interview.ing.atm.machine.model.Card;
import com.interview.ing.atm.machine.model.Transaction;
import com.interview.ing.atm.machine.repository.CardRepository;
import com.interview.ing.atm.machine.repository.CardRepositoryImpl;

@Service("atmService")
public class AtmService {

	@Autowired
	private CardRepositoryImpl cardRepositoryImpl;

	@Autowired
	private BankAccountService bankAccountService;
	
	@Autowired
	private CardRepository cardRepository;

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * Verifies if the card is not expired and if there is no other card inserted and throws an exception if true.
	 * Otherwise it saves the card into the database.
	 * 
	 * @param card The card object.
	 * @return Returns the card information.
	 */
	public Card insertCard(Card card) {
		if (card.getExpirationDate().compareTo(Instant.now()) < 1) {
			logger.warn("The inserted card is expired");
			throw new IllegalArgumentException("The card is expired");
		}

		if (cardRepositoryImpl.findAllEntities().iterator().hasNext()) {
			logger.warn("Cannot insert more than one card");
			throw new IllegalArgumentException("Cannot insert more than one card");
		}

		return cardRepositoryImpl.saveEntity(card);
	}

	/**
	 * Removes the card from the atm.
	 * 
	 * @param cardId The id of the card.
	 */
	public void ejectCard(Integer cardId) {
		cardRepository.deleteById(cardId);
	}

	/**
	 * Validates the card and calls the bankAccountService.
	 * 
	 * @param cardId The id of the card.
	 * @return Returns the bankaccount object with the transactions executed in the last 30 days.
	 */
	public BankAccount getAccountBalance(Integer cardId) {
		Card card = cardRepositoryImpl.findEntityById(cardId);
		if (card == null) {
			logger.warn("Card is not inserted");
			throw new NoSuchElementException("Please insert the card.");
		}

		return this.bankAccountService.getAccountBalance(card.getBankAccount().getBankAccountId());
	}

	/**
	 * Execute a transaction.
	 * 
	 * @param cardId The id of the card.
	 * @param transaction The transaction to be executed.
	 * @return Returns the updated value of the BankAccount object.
	 */
	public BankAccount executeTransaction(Integer cardId, Transaction transaction) {
		Card card = cardRepositoryImpl.findEntityById(cardId);
		if (card == null) {
			logger.warn("Card is not inserted");
			throw new NoSuchElementException("Please insert the card.");
		}

		if (transaction.getDate().compareTo(Instant.now()) > 1) {
			logger.warn("Invalid transaction date.");
			throw new IllegalArgumentException("Invalid transaction date.");
		}

		return this.bankAccountService.executeTransaction(card.getBankAccount().getBankAccountId(), transaction);
	}

}
