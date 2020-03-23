# atm

The service it's exposing 4 api's:

| Request Type | Request path | Operation |
| --- | --- | --- |
| POST         | /api/v1/atm/cards |  Insert the card operation.|
| DELETE | /api/v1/atm/card/{cardId} | Eject card operation. |
| GET | /card/{cardId}/account | Get account balance. |
| POST | /card/{cardId}/account| Execute a transaction on the account. |


Testing the endpoints:

1. Insert card:

Successful operation
	![Insert card successfully](insertCardSuccessful.jpg)
Throwing exception
	![Insert card exception](insertCardException.jpg)

2. Delete card

![Delete card](deleteCardSuccess.jpg)

3. Bank account
	Get bank account successfully
	![Get bank account successfully](getBankAccount.jpg)
	
	Get bank account exception
	![Get bank account exception](getBankAccountException.jpg)
	
4. Execute transaction
	![Execute transaction](executeTransaction.jpg)