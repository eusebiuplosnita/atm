package com.interview.ing.atm.machine.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.interview.ing.atm.machine.repository.BankAccountRepositoryImpl;

public class BankAccountService {

	@Autowired
	BankAccountRepositoryImpl bankAccountRepo;
}
