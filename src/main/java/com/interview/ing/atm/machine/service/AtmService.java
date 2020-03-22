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

	public Card insertCard(Card card) {
		if (card.getExpirationDate().compareTo(Instant.now()) < 1) {
			logger.warn("The inserted card is expired");
			throw new IllegalArgumentException("The card is expired");
		}

		if (cardRepositoryImpl.findAllEntities().iterator().hasNext()) {
			logger.warn("Cannot insert more than one card");
			throw new IllegalArgumentException("Cannot insert more than one card");
		}

		Card savedCard = cardRepositoryImpl.saveEntity(card);
		return cardRepositoryImpl.findEntityById(savedCard.getCardId());
	}

	public void ejectCard(Integer cardId) {
		cardRepository.deleteById(cardId);
	}

	public BankAccount getAccountBalance(Integer cardId) {
		Card card = cardRepositoryImpl.findEntityById(cardId);
		if (card == null) {
			logger.warn("Card is not inserted");
			throw new NoSuchElementException("Please insert the card.");
		}

		int account = card.getBankAccount().getBankAccountId();

		return this.bankAccountService.getAccountBalance(account);
	}

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

		int bankAccount = card.getBankAccount().getBankAccountId();
		return this.bankAccountService.executeTransaction(bankAccount, transaction);
	}

}
