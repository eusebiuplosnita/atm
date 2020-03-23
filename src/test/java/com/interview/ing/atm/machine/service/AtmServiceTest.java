package com.interview.ing.atm.machine.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.interview.ing.atm.machine.model.BankAccount;
import com.interview.ing.atm.machine.model.Card;
import com.interview.ing.atm.machine.model.Transaction;
import com.interview.ing.atm.machine.repository.CardRepositoryImpl;

/**
 * Tests suite for the {@link AtmService} class
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AtmServiceTest {

	@MockBean
	private CardRepositoryImpl cardRepository;
	
	@MockBean
	private BankAccountService bankAccountService;
	
	@Autowired
	private AtmService atmService;
	
	@Test
	public void InsertCardSuccessfullyTest() {
		Card card = new Card(1, new BankAccount(1), "Popescu", Instant.parse("2021-03-20T00:50:49.438018200Z"));
		Mockito.when(cardRepository.saveEntity(Mockito.any())).thenReturn(card);
		Assert.assertEquals(card, atmService.insertCard(card));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void insertCardThrowsCardExpiredExceptionTest() {
		Card card = new Card(1, new BankAccount(1), "Popescu", Instant.now());
		Mockito.when(cardRepository.saveEntity(Mockito.any())).thenReturn(card);
		atmService.insertCard(card);
	}
	
	@Test
	public void getAccountBalanceTest() {
		List<Transaction> transactions = new ArrayList<>();
		transactions.add(new Transaction("withdraw", 100.15, Instant.parse("2020-03-20T00:50:49.438018200Z")));
		transactions.add(new Transaction("withdraw", 50.15, Instant.parse("2020-02-18T00:50:49.438018200Z")));
		BankAccount bankAccount = new BankAccount(1, "ROING2354236523754354", 1500.00, transactions);
		Card card = new Card(1, bankAccount, "Popescu", Instant.parse("2021-03-20T00:50:49.438018200Z"));
		
		Mockito.when(cardRepository.findEntityById(Mockito.any())).thenReturn(card);
		Mockito.when(bankAccountService.getAccountBalance(Mockito.any())).thenReturn(card.getBankAccount());
		
		BankAccount result = atmService.getAccountBalance(1);
		Assert.assertEquals(result.getTransactions().size(), 2);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void getAccountBalanceThrowsExceptionTest() {		
		Mockito.when(cardRepository.findEntityById(Mockito.any())).thenReturn(null);
		atmService.getAccountBalance(1);
	}
}
