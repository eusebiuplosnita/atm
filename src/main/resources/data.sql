CREATE SCHEMA BANK;

DROP TABLE IF EXISTS bankAccounts;
DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS transactions;

CREATE TABLE bankAccounts(bank_account_id INT NOT NULL PRIMARY KEY,
	iban_code VARCHAR(250) NOT NULL, 
	balance DOUBLE NOT NULL
	);
	
CREATE TABLE transactions(id INT NOT NULL PRIMARY KEY,
	bank_account_id INT NOT NULL,
	transaction_type VARCHAR(10) NOT NULL,
	amount DOUBLE NOT NULL,
	transactionDate DATE NOT NULL
	);

CREATE TABLE cards(card_id INT NOT NULL PRIMARY KEY,
	bank_account_id INT NOT NULL,
	owner VARCHAR(20) NOT NULL,
	expiration_date DATE NOT NULL
	);	
	
INSERT into bankAccounts(bank_account_id, iban_code, balance) values (1, 'ROING2345234723574', 5000.00);
INSERT into bankAccounts(bank_account_id, iban_code, balance) values (2, 'ROBCR2616849844845', 10000.01);
INSERT into bankAccounts(bank_account_id, iban_code, balance) values (3, 'ROBRD2616849844800', 999.56);

COMMIT;
