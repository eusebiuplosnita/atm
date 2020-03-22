package com.interview.ing.atm.machine.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import com.interview.ing.atm.machine.entities.BankAccountEntity;
import com.interview.ing.atm.machine.model.BankAccount;

public class BankAccountRepositoryImpl extends BaseRepository<BankAccount, BankAccountEntity, Integer> {

	@Autowired
	BankAccountRepository bankAccountRepo;

	public BankAccountRepositoryImpl(Class<BankAccount> domainClass, Class<BankAccountEntity> entityClass) {
		super(domainClass, entityClass);
	}
	
	@Override
	protected CrudRepository<BankAccountEntity, Integer> getRepository() {
		return this.bankAccountRepo;
	}
}
