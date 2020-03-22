package com.interview.ing.atm.machine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.interview.ing.atm.machine.entities.TransactionEntity;

@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
	
	 @Query("SELECT t FROM TransactionEntity t WHERE t.bankAccount.bankAccountId = ?1")
	List<TransactionEntity> findByBankAccountId(Integer bankAccountId);	
}
