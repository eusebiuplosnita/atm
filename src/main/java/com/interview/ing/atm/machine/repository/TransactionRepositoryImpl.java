package com.interview.ing.atm.machine.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.interview.ing.atm.machine.entities.TransactionEntity;
import com.interview.ing.atm.machine.model.Transaction;

/**
 *	Extends the basic operations from BaseRepository. 
 */
@Component
public class TransactionRepositoryImpl extends BaseRepository<Transaction, TransactionEntity, Integer> {

	@Autowired
	TransactionRepository transactionRepo;

	public TransactionRepositoryImpl() {
		super(Transaction.class, TransactionEntity.class);
	}
	
	@Override
	protected CrudRepository<TransactionEntity, Integer> getRepository() {
		return this.transactionRepo;
	}
	
	public List<Transaction> findByBankAccountId(Integer bankAccountId) {
		return this.transactionRepo.findByBankAccountId(bankAccountId).stream()
				.map(entity -> mapper.map(entity, Transaction.class)).collect(Collectors.toList());
	}
}
