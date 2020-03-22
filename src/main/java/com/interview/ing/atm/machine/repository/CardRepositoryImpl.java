package com.interview.ing.atm.machine.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.interview.ing.atm.machine.entities.CardEntity;
import com.interview.ing.atm.machine.model.Card;

/**
 *	Extends the basic operations from BaseRepository. 
 */
@Component
public class CardRepositoryImpl extends BaseRepository<Card, CardEntity, Integer> {

	@Autowired
	CardRepository cardRepo;

	public CardRepositoryImpl() {
		super(Card.class, CardEntity.class);
	}
	
	@Override
	protected CrudRepository<CardEntity, Integer> getRepository() {
		return this.cardRepo;
	}
}
