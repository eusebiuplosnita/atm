package com.interview.ing.atm.machine.repository;

import org.springframework.data.repository.CrudRepository;

import com.interview.ing.atm.machine.entities.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {

}
