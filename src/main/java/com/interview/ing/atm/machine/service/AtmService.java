package com.interview.ing.atm.machine.service;

import java.time.Instant;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.ing.atm.machine.exceptions.NotFoundException;
import com.interview.ing.atm.machine.model.BankAccount;
import com.interview.ing.atm.machine.model.Card;
import com.interview.ing.atm.machine.repository.CardRepository;

@Service("atmService")
public class AtmService {
	
	@Autowired
	private CardRepository cardRepository;
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	public Card insertCard(Card card) {
		if (card.getExpirationDate().compareTo(Instant.now()) < 1) {
			throw new IllegalArgumentException("The card is expired");
		}
		return cardRepository.save(card);
	}
	
	public void ejectCard(Integer cardId) {
		cardRepository.deleteById(cardId);
	}
	
	public BankAccount getAccountBalance(Integer cardId) throws NotFoundException {
		Optional<Card> optionalCard = cardRepository.findById(cardId);
		if(!optionalCard.isPresent()) {
			logger.error("Card is not inserted");
			throw new NotFoundException("Please insert the card.");
		}
		return optionalCard.get().getBankAccount();
	}
	
	public BankAccount executeTransaction(Integer cardId, Transaction transaction) throws NotFoundException {
		Optional<Card> optionalCard = cardRepository.findById(cardId);
		if(!optionalCard.isPresent()) {
			logger.error("Card is not inserted");
			throw new NotFoundException("Please insert the card.");
		}
		
		//execute transaction
		cardRepository.save(optionalCard.get());
		return optionalCard.get().getBankAccount();
	}
	
}
