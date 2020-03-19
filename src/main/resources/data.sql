CREATE SCHEMA BANK;

CREATE TABLE bankAccounts(id INT NOT NULL PRIMARY KEY,
	ibanCode VARCHAR(250) NOT NULL, 
	BALANCE DOUBLE NOT NULL
	);

INSERT into bankAccounts(id, ibanCode, balance) values (1, 'ROING2345234723574', 5000.00);
INSERT into bankAccounts(id, ibanCode, balance) values (2, 'ROBCR2616849844845', 10000.01);
INSERT into bankAccounts(id, ibanCode, balance) values (3, 'ROBRD2616849844800', 999.56);

COMMIT;
