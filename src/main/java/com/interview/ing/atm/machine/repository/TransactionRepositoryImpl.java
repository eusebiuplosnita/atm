package com.interview.ing.atm.machine.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.interview.ing.atm.machine.entities.TransactionEntity;
import com.interview.ing.atm.machine.model.Transaction;

public class TransactionRepositoryImpl extends BaseRepository<Transaction, TransactionEntity, Integer> {

	@Autowired
	TransactionRepository transactionRepo;

	public TransactionRepositoryImpl(Class<Transaction> domainClass, Class<TransactionEntity> entityClass) {
		super(domainClass, entityClass);
	}
	
	@Override
	protected CrudRepository<TransactionEntity, Integer> getRepository() {
		return this.transactionRepo;
	}
}
