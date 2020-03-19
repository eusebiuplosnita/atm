package com.interview.ing.atm.machine.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.ing.atm.machine.model.BankAccount;
import com.interview.ing.atm.machine.model.Card;
import com.interview.ing.atm.machine.repository.CardRepository;

@Service("atmService")
public class AtmService {
	
	@Autowired
	private CardRepository cardRepository;
	
	public Card insertCard(Card card) {
		//validate card
		return cardRepository.save(card);
	}
	
	public void ejectCard(Integer cardId) {
		cardRepository.deleteById(cardId);
	}
	
	public BankAccount getAccountBalance(Integer cardId) {
		Optional<Card> optionalCard = cardRepository.findById(cardId);
		if(optionalCard.isPresent()) {
			return optionalCard.get().getBankAccount();
		} else {
			//throw exception here
			return null;
		}
	}
	
	public BankAccount executeTransaction(Integer cardId, Transaction transaction) {
		Optional<Card> optionalCard = cardRepository.findById(cardId);
		if(optionalCard.isPresent()) {
			//execute transaction
			cardRepository.save(optionalCard.get());
			return optionalCard.get().getBankAccount();
		} else {
			//throw exception here
			return null;
		}
	}
	
}
