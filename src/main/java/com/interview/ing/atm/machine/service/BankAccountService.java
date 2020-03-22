package com.interview.ing.atm.machine.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.interview.ing.atm.machine.model.BankAccount;
import com.interview.ing.atm.machine.model.Transaction;
import com.interview.ing.atm.machine.repository.BankAccountRepositoryImpl;
import com.interview.ing.atm.machine.repository.TransactionRepositoryImpl;

@Service("bankAccountService")
public class BankAccountService {

	@Autowired
	BankAccountRepositoryImpl bankAccountRepo;
	
	@Autowired
	TransactionRepositoryImpl transactionRepo;
	
	public BankAccount findById(Integer id) {
		return bankAccountRepo.findEntityById(id);
	}
	
	public BankAccount getAccountBalance(Integer id) {
		BankAccount ba = bankAccountRepo.findEntityById(id);
		ba.setTransactions(transactionRepo.findByBankAccountId(id).stream()
				.filter(t -> Instant.now().minus(30, ChronoUnit.DAYS).compareTo(t.getDate()) < 1)
				.collect(Collectors.toList()));
		return ba;
	}
	
	public BankAccount executeTransaction(Integer bankAccountId, Transaction transaction) {
		BankAccount bankAccount = bankAccountRepo.findEntityById(bankAccountId);
		
		switch (transaction.getType()) {
			case "withdraw": {
					if (bankAccount.getBalance() - transaction.getAmount() < 0) {
						throw new IllegalArgumentException("Insufficient funds!");
					}
					bankAccount.setBalance(bankAccount.getBalance() - transaction.getAmount());
					this.transactionRepo.saveEntity(transaction);
					return bankAccountRepo.saveEntity(bankAccount);
				} 
			case "deposit": {
					bankAccount.setBalance(bankAccount.getBalance() + transaction.getAmount());
					this.transactionRepo.saveEntity(transaction);
					return bankAccountRepo.saveEntity(bankAccount);
				} 
			default: 
				throw new IllegalArgumentException("Transaction type not supported.");
		}
	}
}
