package com.interview.ing.atm.machine.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.interview.ing.atm.machine.entities.CardEntity;
import com.interview.ing.atm.machine.model.Card;

public class CardRepositoryImpl extends BaseRepository<Card, CardEntity, Integer> {

	@Autowired
	CardRepository cardRepo;

	public CardRepositoryImpl(Class<Card> domainClass, Class<CardEntity> entityClass) {
		super(domainClass, entityClass);
	}
	
	@Override
	protected CrudRepository<CardEntity, Integer> getRepository() {
		return this.cardRepo;
	}
}
