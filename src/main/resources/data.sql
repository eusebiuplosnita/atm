CREATE SCHEMA BANK;

DROP TABLE cards;

CREATE TABLE bankAccounts(bankAccountId INT NOT NULL PRIMARY KEY,
	ibanCode VARCHAR(250) NOT NULL, 
	BALANCE DOUBLE NOT NULL
	);
	
CREATE TABLE transactions(id INT NOT NULL PRIMARY KEY,
	bankAccountId INT NOT NULL,
	transactionType VARCHAR(10) NOT NULL,
	amount DOUBLE NOT NULL,
	transactionDate DATE NOT NULL
	);

CREATE TABLE cards(id INT NOT NULL PRIMARY KEY,
	bankAccountId INT NOT NULL,
	owner VARCHAR(20) NOT NULL,
	expirationDate DATE NOT NULL
	);	
	
INSERT into bankAccounts(bankAccountId, ibanCode, balance) values (1, 'ROING2345234723574', 5000.00);
INSERT into bankAccounts(bankAccountId, ibanCode, balance) values (2, 'ROBCR2616849844845', 10000.01);
INSERT into bankAccounts(bankAccountId, ibanCode, balance) values (3, 'ROBRD2616849844800', 999.56);

COMMIT;
