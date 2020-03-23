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
	![Insert card successfully](https://github.com/eusebiuplosnita/atm/blob/master/insertCardSuccessful.JPG)  


Throwing exception  
	![Insert card exception](https://github.com/eusebiuplosnita/atm/blob/master/insertCardException.JPG)

2. Delete card  

![Delete card](https://github.com/eusebiuplosnita/atm/blob/master/deleteCardSuccess.JPG)

3. Bank account  
	Get bank account successfully
	![Get bank account successfully](https://github.com/eusebiuplosnita/atm/blob/master/getBankAccount.JPG)
	
	Get bank account exception
	![Get bank account exception](https://github.com/eusebiuplosnita/atm/blob/master/getBankAccountException.JPG)
	
4. Execute transaction  
	![Execute transaction](https://github.com/eusebiuplosnita/atm/blob/master/executeTransaction.JPG)
