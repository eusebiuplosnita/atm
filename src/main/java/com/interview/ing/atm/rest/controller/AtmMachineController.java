package com.interview.ing.atm.rest.controller;

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

import com.interview.ing.atm.machine.model.BankAccount;
import com.interview.ing.atm.machine.model.Card;
import com.interview.ing.atm.machine.service.AtmService;
import com.interview.ing.atm.machine.service.Transaction;

@RestController
@RequestMapping(value = "/api/v1/atm")
public class AtmMachineController {

	@Autowired
	private AtmService atmService;

	@PostMapping("/cards")
	public Card insertCard(@RequestBody Card card) {
		return null;
	}

	@DeleteMapping("/card/{cardId}")
	@ResponseStatus(value = HttpStatus.OK)
	public void ejectCard(@PathVariable Integer cardId) {
		atmService.ejectCard(cardId);
	}

	@GetMapping("/card/{cardId}/account")
	public BankAccount getAccountBalance(@PathVariable Integer cardId) throws Exception {
		return atmService.getAccountBalance(cardId);
	}

	@PostMapping("/card/{cardId}/account")
	public BankAccount executeTransaction(@PathVariable Integer cardId, @RequestBody Transaction transaction)
			throws Exception {
		return atmService.executeTransaction(cardId, transaction);
	}

}
