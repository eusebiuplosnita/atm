package com.interview.ing.atm.machine.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.interview.ing.atm.machine.entities.BankAccountEntity;
import com.interview.ing.atm.machine.model.BankAccount;

/**
 *	Extends the basic operations from BaseRepository. 
 */
@Component
public class BankAccountRepositoryImpl extends BaseRepository<BankAccount, BankAccountEntity, Integer> {

	@Autowired
	BankAccountRepository bankAccountRepo;

	public BankAccountRepositoryImpl() {
		super(BankAccount.class, BankAccountEntity.class);
	}
	
	@Override
	protected CrudRepository<BankAccountEntity, Integer> getRepository() {
		return this.bankAccountRepo;
	}
}
