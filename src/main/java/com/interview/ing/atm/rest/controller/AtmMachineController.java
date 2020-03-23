package com.interview.ing.atm.rest.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.interview.ing.atm.machine.dtos.CardDto;
import com.interview.ing.atm.machine.dtos.TransactionDto;
import com.interview.ing.atm.machine.model.BankAccount;
import com.interview.ing.atm.machine.model.Card;
import com.interview.ing.atm.machine.model.Transaction;
import com.interview.ing.atm.machine.service.AtmService;

@RestController
@RequestMapping(value = "/api/v1/atm")
public class AtmMachineController {

	private final ModelMapper modelMapper = new ModelMapper();

	@Autowired
	private AtmService atmService;

	/**
	 * Inserting the card will create the object in the atm.
	 * 
	 * @param cardDto The card data transfer ojbect.
	 * @return Returns the card created on server.
	 */
	@PostMapping(path = "/cards", consumes = "application/json", produces = "application/json")
	public CardDto insertCard(@RequestBody CardDto cardDto) {
		Card card = atmService.insertCard(modelMapper.map(cardDto, Card.class));
		return modelMapper.map(card, CardDto.class);
	}

	/**
	 * Eject operation will delete the card object from the atm.
	 * 
	 * @param cardId The id of the card to be deleted.
	 */
	@DeleteMapping("/card/{cardId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void ejectCard(@PathVariable String cardId) {
		atmService.ejectCard(Integer.parseInt(cardId));
	}
	
	/**
	 * Gets the account balance and the transactions from the last 30 days.
	 * 
	 * @param cardId The id of the card.
	 * @return Returns the account balance.
	 * @throws Exception
	 */
	@GetMapping("/card/{cardId}/account")
	public BankAccount getAccountBalance(@PathVariable String cardId) throws Exception {
		return atmService.getAccountBalance(Integer.parseInt(cardId));
	}
	
	/**
	 * Executes a transaction(withdraw, deposit,etc.).
	 * 
	 * @param cardId The id of the card.
	 * @param transaction The transaction to be executed.
	 * @return Returns the bank account.
	 * @throws Exception
	 */
	@PostMapping(path = "/card/{cardId}/account", consumes = "application/json", produces = "application/json")
	public BankAccount executeTransaction(@PathVariable String cardId, @RequestBody TransactionDto transaction)
			throws Exception {
		return atmService.executeTransaction(Integer.parseInt(cardId), modelMapper.map(transaction, Transaction.class));
	}

}
