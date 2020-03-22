package com.interview.ing.atm.machine.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.ing.atm.machine.model.BankAccount;
import com.interview.ing.atm.machine.model.Transaction;
import com.interview.ing.atm.machine.repository.BankAccountRepositoryImpl;
import com.interview.ing.atm.machine.repository.TransactionRepositoryImpl;

/**
 * Tests suite for the {@link BankAccountService} class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BankAccountServiceTest {

	@MockBean
	private BankAccountRepositoryImpl bankAccountRepository;
	
	@MockBean
	private TransactionRepositoryImpl transactionRepository;
	
	@Autowired
	private BankAccountService bankAccountService;

	@Test
	public void getBankAccountBalanceTest() {
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(new Transaction("withdraw", 100.15, Instant.parse("2020-03-20T00:50:49.438018200Z")));
		transactions.add(new Transaction("withdraw", 50.15, Instant.parse("2020-02-18T00:50:49.438018200Z")));
		BankAccount bankAccount = new BankAccount(1, "ROING2354236523754354", 1500.00, transactions);
		
		Mockito.when(this.bankAccountRepository.findEntityById(Mockito.anyInt())).thenReturn(bankAccount);
		Mockito.when(this.transactionRepository.findByBankAccountId(Mockito.anyInt())).thenReturn(transactions);
		
		Assert.assertEquals(1, this.bankAccountService.getAccountBalance(1).getTransactions().size());
	}
	
	@Test
	public void executeWithdrawTransactionTest() {
		Transaction transaction = new Transaction("withdraw", 200.00, Instant.now());
		BankAccount bankAccount = new BankAccount(1, "ROING2354236523754354", 1500.00, new ArrayList<>());
		BankAccount savedBankAccount = new BankAccount(1, "ROING2354236523754354", 1300.00, new ArrayList<>());
		Mockito.when(this.bankAccountRepository.findEntityById(Mockito.anyInt())).thenReturn(bankAccount);
		Mockito.when(this.bankAccountRepository.saveEntity(Mockito.any())).thenReturn(savedBankAccount);
		Mockito.when(this.transactionRepository.saveEntity(Mockito.any())).thenReturn(transaction);
		
		assertEquals(1300.00, this.bankAccountService.executeTransaction(1, transaction).getBalance());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void executeWithdrawTransactionThrowsExceptionTest() {
		Transaction transaction = new Transaction("withdraw", 200.00, Instant.now());
		BankAccount bankAccount = new BankAccount(1, "ROING2354236523754354", 150.00, new ArrayList<>());
		Mockito.when(this.bankAccountRepository.findEntityById(Mockito.anyInt())).thenReturn(bankAccount);
		
		this.bankAccountService.executeTransaction(1, transaction);
	}
	
}
