package com.interview.ing.atm.machine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.interview.ing.atm.machine.model.BankAccount;

@RepositoryRestResource
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

}
